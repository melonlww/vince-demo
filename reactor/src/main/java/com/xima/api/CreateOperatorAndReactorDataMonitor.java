package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 数据监听器
 */
public class CreateOperatorAndReactorDataMonitor {

    private static final Map<Class, FluxSink> handlers = new ConcurrentHashMap<>();

    /**
     * 监控指定类型的数据
     *
     * @param clz     数据类型
     * @param handler 数据消费方式
     */
    public static void monitor(Class clz, Consumer handler) {
        Flux objectFlux = Flux.create(sink -> {
            handlers.put(clz, sink);
            sink.onCancel(() -> handlers.remove(clz));
        }, FluxSink.OverflowStrategy.LATEST);

        objectFlux.subscribe(handler);
    }

    /**
     * 取消监控数据
     *
     * @param clz 数据类型
     */
    public static void unMonitor(Class clz) {
        handlers.remove(clz);
    }

    /**
     * 发布数据
     *
     * @param object
     */
    public static void publish(Object object) {
        handlers.forEach((key, value) -> {
            if (key.equals(object.getClass())) {
                value.next(object);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        CreateOperatorAndReactorDataMonitor.monitor(String.class, e -> Utils.println("String值：" + e));
        CreateOperatorAndReactorDataMonitor.monitor(Integer.class, e -> Utils.println("Integer值：" + e));
        CreateOperatorAndReactorDataMonitor.monitor(BigDecimal.class, e -> Utils.println("BigDecimal值：" + e));
        Random random = new Random();
        while (true) {
            int randomInt = random.nextInt(4);
            if(randomInt == 0){
//                System.out.println("unMonitor BigDecimal");
//                CreateOperatorAndReactorDataMonitor.unMonitor(BigDecimal.class);
            } else if (randomInt == 1) {
                CreateOperatorAndReactorDataMonitor.publish("Hello world!");
            } else if (randomInt == 2) {
                CreateOperatorAndReactorDataMonitor.publish(1);
            } else if (randomInt == 3){
                CreateOperatorAndReactorDataMonitor.publish(BigDecimal.TEN);
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
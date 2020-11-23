package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

/**
 * generate 方法生成同步并且一对一提交 Flux ，sink 实现 SynchronousSink
 */
public class GenerateOperatorDemo {

    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(
                () -> 0, // 数据源
                (value, sink) -> { // value 为当前执行的值，sink 是 单信号 Subscriber 的抽象
                    sink.next("value : " + value);
                    if (value == 10) sink.complete();
                    return value + 1;
                });
        flux.subscribe(Utils::println);
    }
}

package com.xima.reactor;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

public class FluxAsyncDemo {

    public static void main(String[] args) throws InterruptedException {
        //当前线程执行
//        Flux.range(0, 10)
//                .publishOn(Schedulers.immediate())
//                .subscribe(Utils::println);
        //单线程异步执行
//        Flux.range(0, 10)
//                .publishOn(Schedulers.single())
//                .subscribe(Utils::println);
        //弹性线程池异步执行  this.evictor = Executors.newScheduledThreadPool(1, EVICTOR_FACTORY);
        Flux.range(0, 10)
                .publishOn(Schedulers.elastic())
                .subscribe(Utils::println);
        //并行线程池异步执行 DEFAULT_POOL_SIZE = Runtime.getRuntime().availableProcessors()
        Flux.range(0, 10)
                .publishOn(Schedulers.parallel())
                .subscribe(Utils::println);

        Thread.currentThread().join(1 * 1000);
    }
}

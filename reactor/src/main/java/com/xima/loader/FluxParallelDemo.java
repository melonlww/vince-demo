package com.xima.loader;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * 多线程并行执行
 */
public class FluxParallelDemo extends DataLoader {

     void doLoad() {
        Flux.just(1, 2, 3).parallel(100).runOn(Schedulers.newElastic("elasticThread")).subscribe(i -> {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "    " + System.currentTimeMillis() + " finish:" + i);
        });
    }

    public static void main(String[] args) throws InterruptedException {
        new FluxParallelDemo().doLoad();
    }
}

package com.xima.loader;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoLoader extends DataLoader {

    private int i;

    public MonoLoader(int i){
        this.i = i;
    }

    protected void doLoad() {
        Mono<Integer> r = Mono.fromCallable(() -> super.loadConfigurations())
//                .publishOn(Schedulers.parallel())
                .subscribeOn(Schedulers.parallel())
                .map(super::loadUsers)
                .map(super::loadOrders);
        System.out.println(r.block());
    }

    protected void doLoad2() {
        Flux.just(1, 2, 3).publishOn(Schedulers.newElastic("elasticThread" + this.i)).subscribe(i -> {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "    " + System.currentTimeMillis() + " finish:" + i);
        });
    }

    public static void main(String[] args) throws InterruptedException {
//        new MonoLoader().doLoad();
        for (int i = 0; i < 50; i++) {
            new MonoLoader(i).doLoad2();
        }
    }

}

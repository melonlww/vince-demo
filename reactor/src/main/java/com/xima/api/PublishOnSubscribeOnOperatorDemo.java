package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class PublishOnSubscribeOnOperatorDemo {

    public static void main(String[] args) {
        Flux.just("tom").map(s -> {
                    Utils.println("map");
                    return s.concat("@mail.com");
                })
                .publishOn(Schedulers.newElastic("thread-publishOn"))
                .filter(s -> {
                    Utils.println("filter");
                    return s.startsWith("t");
                })
                .subscribeOn(Schedulers.newElastic("thread-subscribeOn"))
                .subscribe(s -> {
                    Utils.println("subscribe" + s);
                });
    }
}

package com.xima.reactor;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

public class FluxAPIDemo {

    public static void main(String[] args) {

        //BiFunction(a,b)->a+b
        Flux.generate(() -> 0, (value, sink) -> {
            if (value == 3) {
                sink.complete();
            } else {
                sink.next("value:" + value);
            }
            return value + 1;
        }).subscribe(Utils::println, Utils::println, () -> {
            Utils.println("Subscription is completed!");
        });
    }

}

package com.xima.api;

import reactor.core.publisher.Flux;

public class CreateOperatorDemo {

    public static void main(String[] args) {
        Flux.create(sink -> {
            sink.next("create");
            sink.next("create1");
            sink.complete();
        }).subscribe(System.out::println);
    }
}
package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class IntervalOperatorDemo {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(2)).doOnNext(Utils::println).blockLast();
    }
}

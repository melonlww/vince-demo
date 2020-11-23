package com.xima.debug;

import reactor.core.publisher.Flux;

public class FluxLogDebugDemo {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 10)
                .log()
                .take(3);
        flux.subscribe();
    }
}

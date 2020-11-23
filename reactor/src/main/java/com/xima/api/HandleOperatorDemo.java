package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

public class HandleOperatorDemo {
    public static void main(String[] args) {
        Flux.range(0, 10).handle((item, sink) -> {
            if (item % 2 == 0) {
                sink.next("Even : " + item);
            }
        }).subscribe(Utils::println);
    }
}

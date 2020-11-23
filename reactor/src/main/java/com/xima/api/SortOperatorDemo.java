package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

public class SortOperatorDemo {

    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4).sort((o1, o2) -> o2 - o1).take(1).subscribe(Utils::println);
    }
}

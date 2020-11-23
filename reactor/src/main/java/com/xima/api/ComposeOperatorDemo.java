package com.xima.api;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * compose 操作符与 transform 类似，也能够将几个操作符封装到一个函数式中。
 * 主要的区别就是，这个函数式作用到原始序列上的话，是基于每一个订阅者的（on a per-subscriber basis）。
 * 这意味着它对每一个 subscription 可以生成不同的操作链（通过维护一些状态值）。
 *
 */
public class ComposeOperatorDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        Function<Flux<String>, Flux<String>> filterAndMap = f -> {
            if (ai.incrementAndGet() == 1) {
                return f.filter(color -> !color.equals("orange"))
                        .map(String::toUpperCase);
            }
            return f.filter(color -> !color.equals("purple"))
                    .map(String::toUpperCase);
        };

        Flux<String> composedFlux =
                Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                        .doOnNext(System.out::println)
                        .compose(filterAndMap);

        composedFlux.subscribe(d -> System.out.println("Subscriber 1 to Composed MapAndFilter :"+d));
        composedFlux.subscribe(d -> System.out.println("Subscriber 2 to Composed MapAndFilter: "+d));
    }
}

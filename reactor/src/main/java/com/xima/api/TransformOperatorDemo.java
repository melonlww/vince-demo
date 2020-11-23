package com.xima.api;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.function.Function;

/**
 * transform 操作符可以将一段操作链封装为一个函数式（function）。
 * 这个函数式能在操作期（assembly time） 将被封装的操作链中的操作符还原并接入到调用 transform 的位置。
 * 这样做和直接将被封装的操作符 加入到链上的效果是一样的。
 *
 */
public class TransformOperatorDemo {

    public static void main(String[] args) {
        Function<Flux<String>, Flux<String>> filterAndMap =
                f -> f.filter(color -> !color.equals("orange"))
                        .map(String::toUpperCase);

        Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                .doOnNext(System.out::println)
                .transform(filterAndMap)
                .subscribe(d -> System.out.println("Subscriber to Transformed MapAndFilter: "+d));
    }
}

/**
 * blue
 * Subscriber to Transformed MapAndFilter: BLUE
 * green
 * Subscriber to Transformed MapAndFilter: GREEN
 * orange
 * purple
 * Subscriber to Transformed MapAndFilter: PURPLE
 */

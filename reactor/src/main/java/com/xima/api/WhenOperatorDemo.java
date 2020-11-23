package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Mono;


public class WhenOperatorDemo {

    public static void main(String[] args) {

        /**
         * 如果只关心完成A和B
         * 使用when收听A和B完成情况，使用then继续完全不同的Mono：
         *
         * then会忽略之前的数据，因此在它之前使用zip是没有意义的。
         */
        Mono.when(Mono.just(1), Mono.just(5))
                .then(Mono.just("A and B finished, I don't know their value")).subscribe(Utils::println);

        /**
         * 如果关心A和B值
         */
        Mono.zip(Mono.just(1), Mono.just(5))
                .map(tuple2 -> tuple2.getT1() + tuple2.getT2()).subscribe(Utils::println);
    }


}



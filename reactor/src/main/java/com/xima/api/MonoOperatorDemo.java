package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Mono;

public class MonoOperatorDemo {

    public static void main(String[] args) {
        Integer c = null;
        Mono<Integer> b = Mono.fromCallable(()->2).map(i->{
            int e = (Integer)i;
            if((Integer)i == null){
                return 1;
            }else{
                return e;
            }
        }).switchIfEmpty(Mono.fromCallable(()->3));
        System.out.println(b.subscribe(Utils::println));
    }
}

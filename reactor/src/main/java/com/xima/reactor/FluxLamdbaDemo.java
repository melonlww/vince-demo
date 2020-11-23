package com.xima.reactor;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

import java.util.Random;

public class FluxLamdbaDemo {

    public static void main(String[] args) {
//        test1 订阅并且处理（控制台输出）
        Flux.just(1, 2, 3).subscribe(Utils::println);

        //test2 Lambda
//        Random random = new Random();
//        Flux.just(1, 2, 3).map(value -> {
//            //当随机数==3抛出异常
//            if (random.nextInt(4) == 3) {
//                throw new RuntimeException("value must be less than 3!");
//            }
//            return value;
//        }).subscribe(
//                Utils::println,  //处理数据 onNext()
//                Utils::println, //处理异常 onError()
//                () -> Utils.println("Subscription is completed!")
//                ,e->e.request(3)
//        );
    }
}

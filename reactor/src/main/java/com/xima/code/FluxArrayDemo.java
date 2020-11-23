package com.xima.code;

import com.xima.util.Utils;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


public class FluxArrayDemo {
    public static void main(String[] args) {
        Flux.just(1, 2, 3, 4, 5)
                .publishOn(Schedulers.elastic())
                .map(i -> i * i)
                .subscribe(new CoreSubscriber<>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        Utils.println("onSubscribe, " + s.getClass());
                        s.request(5);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Utils.println("onNext, " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {
                        Utils.println("onComplete");
                    }
                });

        Utils.println("ok");
    }
}

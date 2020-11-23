package com.xima.debug;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;


public class FluxDebugDemo {
    public Mono<String> scatterAndGather(Flux<String> urls) {
        return urls.flatMap(url -> doRequest(url))
                .single();
    }

    public Flux<String> doRequest(String xima){
        return Flux.just(xima).defaultIfEmpty("http://www.ximalaya.com");
    }

    public static void main(String[] args) {
        FluxDebugDemo fluxDebugDemo = new FluxDebugDemo();
        Mono<String> toDebug = fluxDebugDemo.scatterAndGather(Flux.just("1","2","3"));
        toDebug.subscribe(Utils::println, Throwable::printStackTrace);
    }
}





/**
 * Hooks.onOperatorDebug() 这种全局性的调试会因为成本较高而影响性能,其影响在于生成的 stack traces 数量
 */
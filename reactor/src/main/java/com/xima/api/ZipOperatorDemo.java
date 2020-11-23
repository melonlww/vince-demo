package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

/**
 * zipWith 操作符把当前流中的元素与另外一个流中的元素按照一对一的方式进行合并。在合并时可以不做任何处理，由此得到的是一个元素类型为 Tuple2 的流；
 * 也可以通过一个 BiFunction 函数对合并的元素进行处理，所得到的流的元素类型为该函数的返回值。
 * 在代码清单 8 中，两个流中包含的元素分别是 a，b 和 c，d。第一个 zipWith 操作符没有使用合并函数，因此结果流中的元素类型为 Tuple2；
 * 第二个 zipWith 操作通过合并函数把元素类型变为 String。
 */
public class ZipOperatorDemo {
    public static void main(String[] args) {
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(Utils::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(Utils::println);


        Flux<String> stringFlux1 = Flux.just("a","b","c","d","e");
        Flux<String> stringFlux2 = Flux.just("f","g","h","i");
        Flux<String> stringFlux3 = Flux.just("1","2","3","4");

        //方法一zipWith
        stringFlux1.zipWith(stringFlux2).subscribe(x -> Utils.println("->{"+x+"}"));
        //方法二zip
        Flux<Tuple3<String,String,String>> tuple2Flux = Flux.zip(stringFlux1,stringFlux2,stringFlux3);
        tuple2Flux.subscribe(x -> Utils.println("->{"+x+"}"));
    }
}

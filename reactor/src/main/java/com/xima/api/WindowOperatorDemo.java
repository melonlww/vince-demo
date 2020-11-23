package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * window 操作符的作用类似于 buffer，所不同的是 window 操作符是把当前流中的元素收集到另外的 Flux 序列中，
 * 因此返回值类型是 Flux<Flux>。在代码清单 7 中，两行语句的输出结果分别是 5 个和 2 个 UnicastProcessor 字符。
 * 这是因为 window 操作符所产生的流中包含的是 UnicastProcessor 类的对象，而 UnicastProcessor 类的 toString 方法输出的就是 UnicastProcessor 字符。
 */
public class WindowOperatorDemo {

    public static void main(String[] args) {
        Flux.range(1, 100).window(20).subscribe(Utils::println);
        Flux.interval(Duration.ofMillis(100)).window(Duration.ofMillis(1001)).take(2).toStream().forEach(Utils::println);
    }
}

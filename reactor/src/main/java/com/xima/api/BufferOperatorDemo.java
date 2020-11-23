package com.xima.api;

import com.xima.util.Utils;
import reactor.core.publisher.Flux;

/**
 * 这两个操作符的作用是把当前流中的元素收集到集合中，并把集合对象作为流中的新元素。在进行收集时可以指定不同的条件：所包含的元素的最大数量和收集的时间。
 * 方法 buffer()仅使用一个条件，而 bufferTimeout()可以同时指定两个条件。指定时间间隔时可以使用 Duration 对象或毫秒数，即使用 bufferMillis()或 bufferTimeoutMillis()两个方法。
 * 除了元素数量和时间之外，还可以通过 bufferUntil 和 bufferWhile 操作符来进行收集。这两个操作符的参数是表示每个集合中的元素所要满足的条件的 Predicate 对象。
 * bufferUntil 会一直收集直到 Predicate 返回为 true。使得 Predicate 返回 true 的那个元素可以选择添加到当前集合或下一个集合中；bufferWhile 则只有当 Predicate 返回 true 时才会收集。一旦值为 false，会立即开始下一次收集
 * 需要注意的是，在第二个案例中，首先通过 toStream()方法把 Flux 序列转换成 Java 8 中的 Stream 对象，再通过 forEach()方法来进行输出。这是因为序列的生成是异步的，而转换成 Stream 对象可以保证主线程在序列生成完成之前不会退出，从而可以正确地输出序列中的所有元素。
 */
public class BufferOperatorDemo {

    public static void main(String[] args) {
        Flux.range(1, 100).buffer(20).subscribe(Utils::println);
//        Flux.interval(Duration.ofMillis(100)).buffer(Duration.ofMillis(1001)).take(2).toStream().forEach(Utils::println);
//        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(Utils::println);
////        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(Utils::println);
    }
}

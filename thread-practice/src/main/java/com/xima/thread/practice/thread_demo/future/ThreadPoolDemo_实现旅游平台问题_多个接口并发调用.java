package com.xima.thread.practice.thread_demo.future;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo_实现旅游平台问题_多个接口并发调用 {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo_实现旅游平台问题_多个接口并发调用 threadPoolDemo实现旅游平台问题多个接口并发调用 = new ThreadPoolDemo_实现旅游平台问题_多个接口并发调用();
        System.out.println(threadPoolDemo实现旅游平台问题多个接口并发调用.getPrices());
    }


    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        threadPool.submit(new Task(123, prices));
        threadPool.submit(new Task(456, prices));
        threadPool.submit(new Task(789, prices));
        /**
         * 它就会在这里等待 3 秒，之后直接返回 prices。
         *
         * 此时，如果前面响应速度快的话，prices 里面最多会有三个值，但是如果每一个响应时间都很慢，那么可能 prices 里面一个值都没有。不论你有多少个，它都会在休眠结束之后，也就是执行完 Thread 的 sleep 之后直接把 prices 返回，并且最终在 main 函数中把这个结果给打印出来。
         *
         * 我们来看一下可能的执行结果，一种可能性就是有 3 个值，即 [3815, 3609, 3819]（数字是随机的）；有可能是 1 个 [3496]、或 2 个 [1701, 2730]，如果每一个响应速度都特别慢，可能一个值都没有。
          */
        Thread.sleep(3000);
        return prices;
    }

    private class Task implements Runnable {
        Integer productId;
        Set<Integer> prices;

        public Task(Integer productId, Set<Integer> prices) {
            this.productId = productId;
            this.prices = prices;
        }

        @Override
        public void run() {
            int price = 0;
            try {
                Thread.sleep((long) (Math.random() * 4000));
                price = (int) (Math.random() * 4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prices.add(price);
        }
    }
}
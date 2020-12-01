package com.xima.thread.practice.thread_demo.future;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo_实现旅游平台问题_多个接口并发调用_超时机制 {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo_实现旅游平台问题_多个接口并发调用_超时机制 countDownLatchDemo实现旅游平台问题多个接口并发调用超时机制 = new CountDownLatchDemo_实现旅游平台问题_多个接口并发调用_超时机制();
        System.out.println(countDownLatchDemo实现旅游平台问题多个接口并发调用超时机制.getPrices());
    }

    private Set<Integer> getPrices() throws InterruptedException {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        CountDownLatch countDownLatch = new CountDownLatch(3);
        threadPool.submit(new Task(123, prices, countDownLatch));
        threadPool.submit(new Task(456, prices, countDownLatch));
        threadPool.submit(new Task(789, prices, countDownLatch));
        /**
         * 这个函数进行等待时，如果三个任务都非常快速地执行完毕了，那么三个线程都已经执行了 countDown 方法，那么这个 await 方法就会立刻返回，不需要傻等到 3 秒钟。
         */
        countDownLatch.await(3, TimeUnit.SECONDS);
        return prices;
    }

    private class Task implements Runnable {
        Integer productId;
        Set<Integer> prices;
        CountDownLatch countDownLatch;

        public Task(Integer productId, Set<Integer> prices,
                    CountDownLatch countDownLatch) {
            this.productId = productId;
            this.prices = prices;
            this.countDownLatch = countDownLatch;
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
            countDownLatch.countDown();
        }
    }
}
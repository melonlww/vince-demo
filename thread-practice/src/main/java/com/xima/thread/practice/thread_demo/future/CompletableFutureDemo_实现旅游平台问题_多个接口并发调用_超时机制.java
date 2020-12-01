package com.xima.thread.practice.thread_demo.future;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class CompletableFutureDemo_实现旅游平台问题_多个接口并发调用_超时机制 {
    public static void main(String[] args)
            throws Exception {
        CompletableFutureDemo_实现旅游平台问题_多个接口并发调用_超时机制 completableFutureDemo实现旅游平台问题多个接口并发调用超时机制 = new CompletableFutureDemo_实现旅游平台问题_多个接口并发调用_超时机制();
        System.out.println(completableFutureDemo实现旅游平台问题多个接口并发调用超时机制.getPrices());
    }

    private Set<Integer> getPrices() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task(123, prices));
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task(456, prices));
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task(789, prices));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        try {
            /**
             * 会尝试等待所有的任务完成，但是最多只会等 3 秒钟，在此之间，如及时完成则及时返回
             */
            allTasks.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        } catch (TimeoutException e) {
        }
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
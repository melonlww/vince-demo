package com.xima.thread.practice.thread_demo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreDemo1_无Semaphore_所有请求打到慢服务 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            service.submit(new Task());
        }
        service.shutdown();
    }
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "调用了慢服务");
            try {
                //模拟慢服务
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
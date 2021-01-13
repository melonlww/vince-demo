package com.xima.design.pattern.单例模式.破坏单例模式.多线程;

import com.xima.design.pattern.单例模式.s2懒汉模式.LazyDoubleCheckSingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLazyDoubleCheckSingletonFactory implements Runnable{

    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            fixedPool.execute(new TestLazyDoubleCheckSingletonFactory());
        }
        fixedPool.shutdown();
    }

    @Override
    public void run() {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(String.format("thread:%s, instance:%s", Thread.currentThread().getId(), instance));
    }
}

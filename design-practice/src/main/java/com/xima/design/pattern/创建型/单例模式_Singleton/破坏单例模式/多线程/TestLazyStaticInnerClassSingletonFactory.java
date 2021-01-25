package com.xima.design.pattern.创建型.单例模式_Singleton.破坏单例模式.多线程;

import com.xima.design.pattern.创建型.单例模式_Singleton.s2懒汉模式.LazyStaticInnerClassSingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLazyStaticInnerClassSingletonFactory implements Runnable {

    public static void main(String[] args) {
        LazyStaticInnerClassSingleton instance = LazyStaticInnerClassSingleton.getInstance();
        System.out.println(instance);

        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            fixedPool.execute(new TestLazyStaticInnerClassSingletonFactory());
        }
        fixedPool.shutdown();
    }

    @Override
    public void run() {
        LazyStaticInnerClassSingleton instance = LazyStaticInnerClassSingleton.getInstance();
        System.out.println(String.format("thread:%s, instance:%s", Thread.currentThread().getId(), instance));
    }
}

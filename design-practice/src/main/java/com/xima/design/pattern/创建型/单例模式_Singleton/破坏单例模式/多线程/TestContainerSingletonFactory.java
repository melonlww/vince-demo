package com.xima.design.pattern.创建型.单例模式_Singleton.破坏单例模式.多线程;

import com.xima.design.pattern.创建型.单例模式_Singleton.s3注册式.ContainerSingleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestContainerSingletonFactory implements Runnable {

    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            fixedPool.execute(new TestLazyDoubleCheckSingletonFactory());
        }
        fixedPool.shutdown();
    }

    @Override
    public void run() {
        Object instance = ContainerSingleton.getInstance("com.xima.design.pattern.单例模式.s3注册式.Pojo");
        System.out.println(String.format("thread:%s, instance:%s", Thread.currentThread().getId(), instance));
    }
}

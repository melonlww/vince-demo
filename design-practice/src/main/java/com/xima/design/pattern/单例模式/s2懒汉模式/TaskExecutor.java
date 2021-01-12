package com.xima.design.pattern.单例模式.s2懒汉模式;

public class TaskExecutor implements Runnable {

    @Override
    public void run() {
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(String.format("thread:%s, instance:%s", Thread.currentThread().getId(), instance));

    }
}

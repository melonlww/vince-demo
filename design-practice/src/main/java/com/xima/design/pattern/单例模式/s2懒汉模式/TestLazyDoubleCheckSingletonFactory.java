package com.xima.design.pattern.单例模式.s2懒汉模式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLazyDoubleCheckSingletonFactory {

    public static void main(String[] args) {

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        for(int i = 0 ;i<2;i++){
            fixedPool.execute(new TaskExecutor());
        }
        fixedPool.shutdown();
    }
}

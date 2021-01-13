package com.xima.design.pattern.单例模式.s4ThreadLocal;

public class ThreadLocalSingleton {

    private final static ThreadLocal<ThreadLocalSingleton> instance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        public ThreadLocalSingleton initialValue(){
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return instance.get();
    }


}

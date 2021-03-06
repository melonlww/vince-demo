package com.xima.design.pattern.创建型.单例模式_Singleton.s4ThreadLocal;

public class TestThreadLocalSingletonFactory {

    public static void main(String[] args) {
        ThreadLocalSingleton instance1 = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton instance2 = ThreadLocalSingleton.getInstance();
        ThreadLocalSingleton instance3 = ThreadLocalSingleton.getInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance3);
    }
}

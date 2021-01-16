package com.xima.design.pattern.创建型.单例模式.s1饿汉模式;

public class TestHungrySingletonFactory {

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        System.out.println(instance);
    }
}

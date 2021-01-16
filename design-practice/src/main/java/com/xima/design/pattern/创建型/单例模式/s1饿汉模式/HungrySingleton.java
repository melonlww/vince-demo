package com.xima.design.pattern.创建型.单例模式.s1饿汉模式;

public class HungrySingleton {

    private final static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return instance;
    }

}

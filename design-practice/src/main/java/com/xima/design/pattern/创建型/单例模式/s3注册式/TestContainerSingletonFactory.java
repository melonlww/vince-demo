package com.xima.design.pattern.创建型.单例模式.s3注册式;

public class TestContainerSingletonFactory {

    public static void main(String[] args) {
        Object instance1 = ContainerSingleton.getInstance("com.xima.design.pattern.单例模式.s3注册式.Pojo");
        Object instance2 = ContainerSingleton.getInstance("com.xima.design.pattern.单例模式.s3注册式.Pojo");

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }
}

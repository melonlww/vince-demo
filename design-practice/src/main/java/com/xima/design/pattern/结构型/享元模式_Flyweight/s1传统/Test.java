package com.xima.design.pattern.结构型.享元模式_Flyweight.s1传统;

public class Test {

    public static void main(String[] args) {

        IFlyweight obj = FlyweightFactory.getFlyweight("test1");
        obj.operation("ext1");

        IFlyweight obj2 = FlyweightFactory.getFlyweight("test1");
        obj2.operation("ext2");

        IFlyweight obj3 = FlyweightFactory.getFlyweight("test2");
        obj3.operation("ext3");

    }
}

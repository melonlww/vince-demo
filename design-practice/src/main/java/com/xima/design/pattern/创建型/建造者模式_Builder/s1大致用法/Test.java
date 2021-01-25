package com.xima.design.pattern.创建型.建造者模式_Builder.s1大致用法;

public class Test {

    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build());
    }
}

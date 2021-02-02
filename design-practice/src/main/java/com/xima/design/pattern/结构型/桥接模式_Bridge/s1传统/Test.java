package com.xima.design.pattern.结构型.桥接模式_Bridge.s1传统;

public class Test {

    public static void main(String[] args) {
        RefinedAbstraction m = new RefinedAbstraction(new ConcreteImplementorA());
        m.operation();
    }
}

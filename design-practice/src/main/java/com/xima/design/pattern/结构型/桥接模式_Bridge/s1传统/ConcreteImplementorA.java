package com.xima.design.pattern.结构型.桥接模式_Bridge.s1传统;

//具体实现
public class ConcreteImplementorA implements IImplementor {
    @Override
    public void operationImpl() {
        System.out.println("i'm ConcreteImplementor A");
    }
}

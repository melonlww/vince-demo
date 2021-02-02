package com.xima.design.pattern.结构型.桥接模式_Bridge.s1传统;

//抽象
public abstract class Abstraction {
    protected IImplementor mImplementor;

    public Abstraction(IImplementor mImplementor) {
        this.mImplementor = mImplementor;
    }

    public void operation(){
        this.mImplementor.operationImpl();
    }
}

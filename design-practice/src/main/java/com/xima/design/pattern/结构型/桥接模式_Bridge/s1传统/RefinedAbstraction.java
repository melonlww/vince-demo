package com.xima.design.pattern.结构型.桥接模式_Bridge.s1传统;

//修正抽象
public class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(IImplementor mImplementor) {
        super(mImplementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}

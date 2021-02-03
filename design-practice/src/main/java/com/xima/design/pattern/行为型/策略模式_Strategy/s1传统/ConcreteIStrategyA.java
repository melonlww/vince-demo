package com.xima.design.pattern.行为型.策略模式_Strategy.s1传统;

//具体策略类 ConcreteIStrategy
public class ConcreteIStrategyA implements IStrategy{
    @Override
    public void algorithm() {
        System.out.println("Strategy A");
    }
}

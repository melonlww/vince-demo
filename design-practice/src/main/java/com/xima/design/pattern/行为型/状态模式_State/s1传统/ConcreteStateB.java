package com.xima.design.pattern.行为型.状态模式_State.s1传统;

public class ConcreteStateB implements IState{
    @Override
    public void handle() {
        System.out.println("StateB do action");
    }
}

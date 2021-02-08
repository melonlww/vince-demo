package com.xima.design.pattern.行为型.状态模式_State.s2传统_自动切换状态;

public class ConcreteStateB extends AbstractState {
    @Override
    public void handle() {
        System.out.println("StateB do action");
    }
}

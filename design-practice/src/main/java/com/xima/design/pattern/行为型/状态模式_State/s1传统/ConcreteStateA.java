package com.xima.design.pattern.行为型.状态模式_State.s1传统;

public class ConcreteStateA implements IState {
    @Override
    public void handle() {
        //必要时刻需要进行状态切换
        System.out.println("StateA do action");
    }
}

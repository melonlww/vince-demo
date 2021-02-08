package com.xima.design.pattern.行为型.状态模式_State.s2传统_自动切换状态;

public class ConcreteStateA extends AbstractState {
    @Override
    public void handle() {
        System.out.println("StateA do action");
        //A状态完成后自动切换到B状态
        this.context.setState(Context.STATE_B);
        this.context.getState().handle();
    }
}

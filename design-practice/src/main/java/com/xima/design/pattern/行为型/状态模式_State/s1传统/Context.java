package com.xima.design.pattern.行为型.状态模式_State.s1传统;

//环境类
public class Context {

    private static final IState STATE_A = new ConcreteStateA();
    private static final IState STATE_B = new ConcreteStateB();
    //默认状态
    private IState currentState = STATE_A;

    public void setState(IState state) {
        this.currentState = state;
    }

    public void handle(){
        this.currentState.handle();
    }
}

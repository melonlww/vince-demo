package com.xima.design.pattern.行为型.状态模式_State.s2传统_自动切换状态;

//环境类
public class Context {

    public static final AbstractState STATE_A = new ConcreteStateA();
    public static final AbstractState STATE_B = new ConcreteStateB();
    //默认状态
    private AbstractState currentState = STATE_A;
    {
        STATE_A.setContext(this);
        STATE_B.setContext(this);
    }

    public void setState(AbstractState state) {
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public AbstractState getState() {
        return currentState;
    }

    public void handle(){
        this.currentState.handle();
    }
}

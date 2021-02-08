package com.xima.design.pattern.行为型.状态模式_State.s2传统_自动切换状态;

public abstract class AbstractState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handle();
}

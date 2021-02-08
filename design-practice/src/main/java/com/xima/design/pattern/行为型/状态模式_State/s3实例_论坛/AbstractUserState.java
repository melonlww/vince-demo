package com.xima.design.pattern.行为型.状态模式_State.s3实例_论坛;

public abstract class AbstractUserState {
    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);
}

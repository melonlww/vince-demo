package com.xima.design.pattern.行为型.状态模式_State.s3实例_论坛;

public class AppContext {
    public static final AbstractUserState STATE_LOGIN = new LoginState();
    public static final AbstractUserState STATE_UNLOGIN = new UnLoginState();

    private AbstractUserState currentState = STATE_UNLOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UNLOGIN.setContext(this);
    }

    public void setState(AbstractUserState state){
        this.currentState = state;
    }

    public AbstractUserState getState() {
        return this.currentState;
    }

    public void favorite(){
        this.currentState.favorite();
    }

    public void comment(String comment){
        this.currentState.comment(comment);
    }
}

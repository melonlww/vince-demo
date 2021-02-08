package com.xima.design.pattern.行为型.状态模式_State.s3实例_论坛;

public class UnLoginState extends AbstractUserState {
    @Override
    public void favorite() {
        this.switch2Login();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switch2Login();
        this.context.getState().comment(comment);
    }


    private void switch2Login() {
        System.out.println("跳转到登录页!");
        this.context.setState(AppContext.STATE_LOGIN);
    }
}

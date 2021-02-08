package com.xima.design.pattern.行为型.状态模式_State.s3实例_论坛;

public class LoginState extends AbstractUserState {
    @Override
    public void favorite() {
        System.out.println("收藏成功");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}

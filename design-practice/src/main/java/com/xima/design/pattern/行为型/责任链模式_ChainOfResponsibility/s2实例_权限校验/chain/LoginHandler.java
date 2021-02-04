package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.chain;

import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.Handler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.Member;

public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功");

        member.setRoleName("管理员");
        if (next != null) {
            next.doHandler(member);
        }
    }
}

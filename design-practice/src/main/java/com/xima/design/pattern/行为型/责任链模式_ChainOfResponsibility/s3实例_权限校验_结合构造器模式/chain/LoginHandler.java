package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.chain;

import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.Handler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.Member;

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

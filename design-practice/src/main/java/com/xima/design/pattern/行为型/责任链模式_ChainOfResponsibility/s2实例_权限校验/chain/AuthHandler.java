package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.chain;

import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.Handler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.Member;

public class AuthHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("运行操作");
    }
}

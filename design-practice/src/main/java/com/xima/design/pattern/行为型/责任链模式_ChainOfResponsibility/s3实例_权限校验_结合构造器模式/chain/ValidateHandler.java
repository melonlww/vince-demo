package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.chain;

import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.Handler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.Member;
import org.springframework.util.StringUtils;

public class ValidateHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if (StringUtils.isEmpty(member.getLoginName())
                || StringUtils.isEmpty(member.getLoginPass())) {
            System.out.println("用户和密码为空");
            return;
        }
        System.out.println("用户和密码不为空，可往下执行");
        if (next != null) {
            next.doHandler(member);
        }
    }
}

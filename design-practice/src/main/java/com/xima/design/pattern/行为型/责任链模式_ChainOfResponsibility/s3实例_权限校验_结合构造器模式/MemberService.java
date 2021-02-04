package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式;

import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.chain.AuthHandler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.chain.LoginHandler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式.chain.ValidateHandler;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName, loginPass));
    }
}

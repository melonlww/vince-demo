package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验;

import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.chain.AuthHandler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.chain.LoginHandler;
import com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验.chain.ValidateHandler;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandler(new Member(loginName, loginPass));

    }
}

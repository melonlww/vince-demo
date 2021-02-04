package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验;

public class Test {

    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("liww","123456");
    }
}

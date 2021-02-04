package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s3实例_权限校验_结合构造器模式;

public class Test {

    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("liww", "123456");
    }
}

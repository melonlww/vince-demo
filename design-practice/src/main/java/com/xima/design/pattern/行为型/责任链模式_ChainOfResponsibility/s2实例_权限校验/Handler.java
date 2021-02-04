package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s2实例_权限校验;

public abstract class Handler {
    protected Handler next;

    public void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(Member member);
}

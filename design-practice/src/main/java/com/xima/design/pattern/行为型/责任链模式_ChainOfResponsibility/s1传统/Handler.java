package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s1传统;

public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler successor) {
        this.nextHandler = successor;
    }

    public abstract void handleRequest(String request);

}

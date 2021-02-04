package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s1传统;

public class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String request) {
        if ("requestB".equals(request)) {
            System.out.println(this.getClass().getSimpleName() + " deal with request:" + request);
            return;
        }
        if (this.nextHandler != null) {
            this.nextHandler.handleRequest(request);
        }
    }
}

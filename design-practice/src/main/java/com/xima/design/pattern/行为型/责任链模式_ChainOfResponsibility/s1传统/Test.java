package com.xima.design.pattern.行为型.责任链模式_ChainOfResponsibility.s1传统;

public class Test {

    public static void main(String[] args) {
        //构建责任链
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNextHandler(handlerB);
        //执行
        handlerA.handleRequest("requestB");
    }
}

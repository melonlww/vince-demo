package com.xima.design.pattern.行为型.中介者模式_Mediator.s1传统;

/**
 * 中介者抽象类
 */
public abstract class Mediator {

    //注册同事
    abstract void register(Colleague colleague);

    //通知中介者，发送消息
    abstract void relay(Colleague colleague);

}


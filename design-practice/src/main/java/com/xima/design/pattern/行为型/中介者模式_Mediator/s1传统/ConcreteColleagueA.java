package com.xima.design.pattern.行为型.中介者模式_Mediator.s1传统;

/**
 * 具体的同事类1
 */
public class ConcreteColleagueA extends Colleague{

    @Override
    public void receive() {
        System.out.println("colleagueA receive message.");
    }

    @Override
    public void send() {
        System.out.println("colleagueA send message.");
        //请中介者转发
        this.mediator.relay(this);
    }

}

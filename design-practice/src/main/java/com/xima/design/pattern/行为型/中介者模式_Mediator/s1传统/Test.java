package com.xima.design.pattern.行为型.中介者模式_Mediator.s1传统;

/**
 * 测试与应用
 */
public class Test {

    public static void main(String[] args) {
        //构建中介者
        Mediator mediator = new ConcreteMediator();

        //构建具体的同事类
        Colleague colleagueA = new ConcreteColleagueA();
        Colleague colleagueB = new ConcreteColleagueB();

        //注册同事
        mediator.register(colleagueA);
        mediator.register(colleagueB);

        //发送消息
        colleagueA.send();
        colleagueB.send();
    }
}
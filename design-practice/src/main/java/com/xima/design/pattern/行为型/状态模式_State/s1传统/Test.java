package com.xima.design.pattern.行为型.状态模式_State.s1传统;

public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateB());
        context.handle();
    }
}

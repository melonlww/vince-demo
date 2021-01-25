package com.xima.design.pattern.结构型.装饰器模式_Decorator.s1传统;

public class Test {

    public static void main(String[] args) {
        Component c1 = new ConcreteComponent();

        Decorator decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();

        Decorator decoratorB = new ConcreteDecoratorB(c1);
        decoratorB.operation();

        Decorator decoratorBandA = new ConcreteDecoratorB(decoratorA);
        decoratorBandA.operation();

    }
}

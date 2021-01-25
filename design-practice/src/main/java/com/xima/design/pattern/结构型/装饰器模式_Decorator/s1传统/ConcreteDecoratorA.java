package com.xima.design.pattern.结构型.装饰器模式_Decorator.s1传统;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private void operationFirst(){
        System.out.println("ConcreteDecoratorA first");
    }

    private void operationLast(){
        System.out.println("ConcreteDecoratorA last");
    }

    public void operation(){
        operationFirst();
        super.operation();
        operationLast();
    }
}

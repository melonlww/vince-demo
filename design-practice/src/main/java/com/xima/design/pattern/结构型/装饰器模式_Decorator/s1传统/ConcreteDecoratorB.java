package com.xima.design.pattern.结构型.装饰器模式_Decorator.s1传统;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    private void operationFirst(){
        System.out.println("ConcreteDecoratorB first");
    }

    private void operationLast(){
        System.out.println("ConcreteDecoratorB last");
    }

    public void operation(){
        operationFirst();
        super.operation();
        operationLast();
    }
}

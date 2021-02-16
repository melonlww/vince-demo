package com.xima.design.pattern.行为型.访问者模式_Visitor.s1传统;

/**
 * 抽象访问者
 */
public abstract class Visitor {

    public abstract void visitConcreteElementA(ConcreteElementA concreteElementA);

    public abstract void visitConcreteElementB(ConcreteElementB concreteElementB);

}
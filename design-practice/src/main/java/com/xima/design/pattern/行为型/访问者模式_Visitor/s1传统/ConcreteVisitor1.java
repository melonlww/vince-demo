package com.xima.design.pattern.行为型.访问者模式_Visitor.s1传统;

/**
 * 具体访问者
 */
public class ConcreteVisitor1 extends Visitor {

    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.println(concreteElementA.getClass().getName() + " 被 " + this.getClass().getName() + " 访问");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.println(concreteElementB.getClass().getName() + " 被 " + this.getClass().getName() + " 访问");
    }

}
package com.xima.design.pattern.行为型.访问者模式_Visitor.s1传统;

/**
 * 具体元素
 */
public class ConcreteElementB extends Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }

    //其它方法
    public void operationB() {

    }

}
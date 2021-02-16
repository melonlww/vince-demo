package com.xima.design.pattern.行为型.访问者模式_Visitor.s1传统;

/**
 * 抽象元素
 */
public abstract class Element {

    public abstract void accept(Visitor visitor);

}
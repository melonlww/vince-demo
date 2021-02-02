package com.xima.design.pattern.行为型.模板模式_Template.s1传统;

public class Test {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();

        abc = new ConcreteClassB();
        abc.templateMethod();
    }
}

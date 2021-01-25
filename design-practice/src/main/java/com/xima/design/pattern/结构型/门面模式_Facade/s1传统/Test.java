package com.xima.design.pattern.结构型.门面模式_Facade.s1传统;

public class Test {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}

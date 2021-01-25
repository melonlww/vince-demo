package com.xima.design.pattern.结构型.门面模式_Facade.s1传统;

public class Facade {
    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    public void doA(){
        a.doA();
    }

    public void doB(){
        b.doB();
    }

    public void doC(){
        c.doC();
    }
}

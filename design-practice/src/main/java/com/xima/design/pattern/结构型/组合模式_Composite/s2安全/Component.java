package com.xima.design.pattern.结构型.组合模式_Composite.s2安全;

public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    //获取分支下的所有叶子构件和树枝构件
    public abstract void display(int depth);

}
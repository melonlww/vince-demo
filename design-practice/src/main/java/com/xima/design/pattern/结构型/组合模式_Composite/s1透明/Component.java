package com.xima.design.pattern.结构型.组合模式_Composite.s1透明;

public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    //增加一个叶子构件或树枝构件
    public abstract void add(Component component);

    //删除一个叶子构件或树枝构件
    public abstract void remove(Component component);

    //获取分支下的所有叶子构件和树枝构件
    public abstract void display(int depth);

}
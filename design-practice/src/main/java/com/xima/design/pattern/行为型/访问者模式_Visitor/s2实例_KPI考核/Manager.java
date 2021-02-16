package com.xima.design.pattern.行为型.访问者模式_Visitor.s2实例_KPI考核;

import java.util.Random;

// 经理
public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    // 一年做的产品数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
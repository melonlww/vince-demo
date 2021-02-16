package com.xima.design.pattern.行为型.访问者模式_Visitor.s2实例_KPI考核;

import java.util.Random;

// 工程师
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    // 工程师一年的代码数量
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
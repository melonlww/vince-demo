package com.xima.design.pattern.行为型.访问者模式_Visitor.s2实例_KPI考核;

import java.util.Random;

// 员工基类
public abstract class Employee {
    public String name;
    // 员工KPI
    public int kpi;

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    // 核心方法，接受Visitor的访问
    public abstract void accept(IVisitor visitor);
}
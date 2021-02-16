package com.xima.design.pattern.行为型.访问者模式_Visitor.s2实例_KPI考核;

public interface IVisitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}

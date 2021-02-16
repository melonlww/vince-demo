package com.xima.design.pattern.行为型.访问者模式_Visitor.s2实例_KPI考核;

/**
 * 访问者模式：
 * 对原始数只能访问，不能改变
 * 大部分情况下，用于数据报表和统计
 * 不同访问者，得到不同的结果
 */
public class Test {

    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}

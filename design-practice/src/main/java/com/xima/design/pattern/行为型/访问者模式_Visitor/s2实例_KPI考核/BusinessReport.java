package com.xima.design.pattern.行为型.访问者模式_Visitor.s2实例_KPI考核;

import java.util.LinkedList;
import java.util.List;

// 员工业务报表类
public class BusinessReport {

    private List<Employee> mEmployees = new LinkedList<>();

    public BusinessReport() {
        mEmployees.add(new Manager("经理-A"));
        mEmployees.add(new Engineer("工程师-A"));
        mEmployees.add(new Engineer("工程师-B"));
        mEmployees.add(new Engineer("工程师-C"));
        mEmployees.add(new Manager("经理-B"));
        mEmployees.add(new Engineer("工程师-D"));
    }

    /**
     * 为访问者展示报表
     *
     * @param visitor 公司高层，如CEO、CTO
     */
    public void showReport(IVisitor visitor) {
        for (Employee employee : mEmployees) {
            employee.accept(visitor);
        }
    }
}
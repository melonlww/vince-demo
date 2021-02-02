package com.xima.design.pattern.行为型.委托模式_Delegate.s2实例_工作安排;

public class EmployeeB implements IEmployee {
    protected String goodAt = "设计";

    @Override
    public void doing(String task) {
        System.out.println("我是员工B，我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}

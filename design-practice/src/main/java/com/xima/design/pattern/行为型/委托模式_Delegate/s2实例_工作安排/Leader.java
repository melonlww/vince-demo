package com.xima.design.pattern.行为型.委托模式_Delegate.s2实例_工作安排;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    private Map<String, IEmployee> employeeMap = new HashMap<>();

    public Leader() {
        employeeMap.put("爬虫", new EmployeeA());
        employeeMap.put("海报图", new EmployeeB());
    }

    @Override
    public void doing(String task) {
        if (!employeeMap.containsKey(task)) {
            System.out.println("这个任务" + task + "不接！");
        }
        employeeMap.get(task).doing(task);
    }
}

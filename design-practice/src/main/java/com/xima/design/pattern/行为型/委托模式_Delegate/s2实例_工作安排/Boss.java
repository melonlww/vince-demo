package com.xima.design.pattern.行为型.委托模式_Delegate.s2实例_工作安排;

public class Boss {
    public void command(String task, Leader leader){
        leader.doing(task);
    }
}

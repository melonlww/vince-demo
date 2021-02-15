package com.xima.design.pattern.行为型.委托模式_Delegate.s1传统;

public class WorkerService implements IReceiveTask {

    @Override
    public void receive(String task) {
        System.out.println("工人开始" + task);
    }
}

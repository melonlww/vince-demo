package com.xima.design.pattern.行为型.委托模式_Delegate.s1传统;

public class Test {

    public static void main(String[] args) {
        String task = "搬砖";
        WorkerService workerService = new WorkerService();
        BossService bossService = new BossService(workerService);
        bossService.receive(task);
    }
}

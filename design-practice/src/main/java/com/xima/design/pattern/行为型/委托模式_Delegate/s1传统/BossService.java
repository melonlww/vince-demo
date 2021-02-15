package com.xima.design.pattern.行为型.委托模式_Delegate.s1传统;

public class BossService implements IReceiveTask {
    private WorkerService workerService;

    public BossService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Override
    public void receive(String task) {
        workerService.receive(task);
    }
}

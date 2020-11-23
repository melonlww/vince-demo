package com.xima.loader;

import java.util.concurrent.TimeUnit;

public abstract class DataLoader {

    public final void load() {
        long startTime = System.currentTimeMillis(); // 开始时间
        doLoad(); // 具体执行
        long costTime = System.currentTimeMillis() - startTime; // 消耗时间
        System.out.println("load() 总耗时：" + costTime + " 毫秒");
    }

    abstract void doLoad();

    protected final int loadConfigurations() {
        loadMock("loadConfigurations()", 1);
        return 1;
    }

    protected final int loadUsers(int i) {
        loadMock("loadUsers()", 2);
        return i + 10;
    }

    protected final int loadOrders(int i) {
        loadMock("loadOrders()", 3);
        return i + 20;
    }


    private void loadMock(String source, int seconds) {
        try {
            long startTime = System.currentTimeMillis();
            long milliseconds = TimeUnit.SECONDS.toMillis(seconds);
            Thread.sleep(milliseconds);
            long costTime = System.currentTimeMillis() - startTime;
            System.out.printf("[线程 : %s] %s 耗时 : %d 毫秒\n", Thread.currentThread().getName(), source, costTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
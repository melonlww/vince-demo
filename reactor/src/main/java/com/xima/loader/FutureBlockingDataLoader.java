package com.xima.loader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future 阻塞问题
 * 如果 DataLoader 的 loadOrders() 方法依赖于 loadUsers() 的结果，而 loadUsers() 又依赖于loadConfigurations()
 */
public class FutureBlockingDataLoader extends DataLoader {
    protected void doLoad() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int i = runCompletely(executorService.submit(super::loadConfigurations));
        int finalI = i;
        int j = runCompletely(executorService.submit(() -> super.loadUsers(finalI)));
        int k = runCompletely(executorService.submit(() -> super.loadOrders(j)));
        System.out.println(k);
        executorService.shutdown();
    }

    private Integer runCompletely(Future<Integer> future) {
        try {
            return future.get();
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }
}
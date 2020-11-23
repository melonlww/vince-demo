package com.xima.loader;

import com.xima.util.Utils;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture 属于异步操作，如果强制等待结束的话，又回到了阻塞编程的方式
 * CompletableFuture 让我们理解到非阻塞不一定提升性能
 *
 * 缺点：缺乏对多个值以及更进一步对背压，超时等操作的处理。
 */
public class CompletableFutureChainDataLoader extends DataLoader {

    protected void doLoad() {
        int i = CompletableFuture.supplyAsync(() -> super.loadConfigurations())
                .thenApply(super::loadUsers)
                .thenApply(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调
                    Utils.println("加载完成");
                })
                .exceptionally(throwable -> {
                    Utils.println("加载异常");
                    return null;
                })
                .join(); // 等待完成
        System.out.println(i);
    }

    public static void main(String[] args) {
        new CompletableFutureChainDataLoader().load();
    }
}
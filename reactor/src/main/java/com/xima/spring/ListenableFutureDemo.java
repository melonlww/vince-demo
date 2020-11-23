package com.xima.spring;

import com.xima.util.Utils;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.ExecutionException;

public class ListenableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncListenableTaskExecutor executor = new SimpleAsyncTaskExecutor("ListenableFutureDemo-");

        //ListenableFuture实例
        ListenableFuture<Integer> future = executor.submitListenable(()-> 1);
        //添加Callback
        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable throwable) {
                Utils.println(throwable);
            }

            @Override
            public void onSuccess(Integer integer) {
                Utils.println(integer);
            }
        });
        //future直到计算结束
        future.get();

        future = executor.submitListenable(()-> 2);
        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable throwable) {
                Utils.println(throwable);
            }

            @Override
            public void onSuccess(Integer integer) {
                Utils.println(integer);
            }
        });
        future.get();
    }

}

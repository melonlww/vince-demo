package com.xima.thread.practice.thread_demo.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask task = forkJoinPool.submit(new Fibonacci(10));
        System.out.println(task.get());
        //2
//        System.out.println(new Fibonacci(10).compute());
    }
}

class Fibonacci extends RecursiveTask<Integer> {
    int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Integer compute() {
        if (n <= 1) {
            return n;
        }
        System.out.println(Thread.currentThread().getName());
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        f2.fork();
        return f1.join() + f2.join();
    }
}
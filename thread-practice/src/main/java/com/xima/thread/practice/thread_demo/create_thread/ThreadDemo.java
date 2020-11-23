package com.xima.thread.practice.thread_demo.create_thread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.实现 Runnable 接口
        Thread t1 = new Thread(new RunnableThread());
        t1.start();
        //2.继承 Thread 类
        Thread t2 = new Thread(new ExtendsThread());
        t2.start();
        //3.线程池创建线程
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new RunnableThread());
        //4.有返回值的 Callable 创建线程
        Future<Integer> future = es.submit(new CallableTask());
        System.out.println(future.get());

        es.shutdown();
    }
}


class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("用实现Runnable接口实现线程");
    }
}

class ExtendsThread extends Thread{

    @Override
    public void run(){
        System.out.println("用Thread类实现线程");
    }
}

class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}


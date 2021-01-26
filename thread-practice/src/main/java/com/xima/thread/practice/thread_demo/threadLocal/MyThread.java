package com.xima.thread.practice.thread_demo.threadLocal;

public class MyThread implements Runnable {
    ThreadLocalTest_为什么ThreadLocal要用WeakReference.ObjectPassing objectPassing = null;
    public MyThread(ThreadLocalTest_为什么ThreadLocal要用WeakReference.ObjectPassing objectPassing){
        this.objectPassing = objectPassing;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("1:"+objectPassing.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
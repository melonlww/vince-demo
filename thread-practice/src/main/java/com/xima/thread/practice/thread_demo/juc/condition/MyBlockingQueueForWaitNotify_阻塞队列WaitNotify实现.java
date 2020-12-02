package com.xima.thread.practice.thread_demo.juc.condition;

import java.util.LinkedList;

class MyBlockingQueueForWaitNotify_阻塞队列WaitNotify实现 {

    private int maxSize;
    private LinkedList<Object> storage;

    public MyBlockingQueueForWaitNotify_阻塞队列WaitNotify实现(int size) {
        this.maxSize = size;
        storage = new LinkedList<>();
    }

    public synchronized void put() throws InterruptedException {
        while (storage.size() == maxSize) {
            this.wait();
        }
        storage.add(new Object());
        this.notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        while (storage.size() == 0) {
            this.wait();
        }
        System.out.println(storage.remove());
        this.notifyAll();
    }
}
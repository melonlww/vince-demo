package com.xima.thread.practice.thread_demo.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueueForWaitNotify<T> {

    private Queue<T> queue;
    private int max = 16;
    private Object lock = new Object();

    public MyBlockingQueueForWaitNotify(int size){
        this.max = size;
        queue = new LinkedList();
    }

    public void put(T o) throws InterruptedException {
        synchronized(lock) {
            try {
                while (queue.size() == max) {
                    lock.wait();
                }
                queue.add(o);
            } finally {
                lock.notifyAll();
            }
        }
    }

    public T take() throws InterruptedException {
        synchronized(lock) {
            try {
                while (queue.size() == 0) {
                    lock.wait();
                }
                T o = queue.remove();
                System.out.println(o + " size:" + queue.size());
                return o;
            } finally {
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        MyBlockingQueueForWaitNotify<Object> blockingQueue = new MyBlockingQueueForWaitNotify(3);

        Runnable producer = ()->{
            for(int i = 0 ; i<10000; i++){
                try {
                    blockingQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable customer = ()->{
            while(true){
                try {
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(customer).start();
        new Thread(customer).start();


    }
}

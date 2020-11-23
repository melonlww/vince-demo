package com.xima.thread.practice.thread_demo.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueForCondition<T> {

    private Queue<T> queue;
    private int max = 16;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition notEmpty = reentrantLock.newCondition();
    private Condition notFull = reentrantLock.newCondition();

    public MyBlockingQueueForCondition(int size){
        this.max = size;
        queue = new LinkedList();
    }

    public void put(T o){
        reentrantLock.lock();
        try {
            while (queue.size() == max) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(o);
            // signalAll 通知所有阻塞线程
            notEmpty.signalAll();
        }finally {
            // 保证unlock
            reentrantLock.unlock();
        }
    }

    public T take(){
        reentrantLock.lock();
        try {
            while(queue.size() == 0){
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T o = queue.remove();
            notFull.signalAll();
            return o;
        }finally {
            // 保证unlock
            reentrantLock.unlock();
        }
    }

    public int size(){
        reentrantLock.lock();
        int num = queue.size();
        reentrantLock.unlock();
        return num;
    }



    public static void main(String[] args) {

        MyBlockingQueueForCondition<Object> blockingQueue = new MyBlockingQueueForCondition(3);

        Runnable producer = ()->{
            while(true){
                blockingQueue.put(new Object());
                System.out.println(blockingQueue.size()+"....");
            }
        };

        Runnable customer = ()->{
            while(true){
                blockingQueue.take();
                System.out.println(blockingQueue.size()+"....");
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(customer).start();
        new Thread(customer).start();


    }


}

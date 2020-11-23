package com.xima.thread.practice.thread_demo.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue(3);

        Runnable producer = ()->{
            while(true){
                try {
                    blockingQueue.put(new Object());
                    System.out.println(blockingQueue.size()+"....");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable customer = ()->{
            while(true){
                try {
                    blockingQueue.take();
                    System.out.println(blockingQueue.size()+"....");
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

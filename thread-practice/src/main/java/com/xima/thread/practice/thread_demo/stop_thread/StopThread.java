package com.xima.thread.practice.thread_demo.stop_thread;

public class StopThread implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
//            System.out.println(count);
//            count++;
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
////                Thread.currentThread().interrupt();
//                e.printStackTrace();
//            }
        }
    }

    void subTask2() throws InterruptedException {
        System.out.println("start");
        Thread.sleep(1000);
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();

        Thread.sleep(20);
        thread.interrupt();

    }
}






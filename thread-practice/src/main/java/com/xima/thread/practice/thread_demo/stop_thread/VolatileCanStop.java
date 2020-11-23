package com.xima.thread.practice.thread_demo.stop_thread;

public class VolatileCanStop implements Runnable{

    private volatile boolean canceled = false;

//    @Override
//    public void run() {
//        int num = 0;
//        try {
//            while (!canceled && num <= 1000000) {
//                if (num % 10 == 0) {
//                    System.out.println(num + "是10的倍数。");
//                }
//                num++;
//                Thread.sleep(1);
//            }
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }

    @Override
    public void run() {
        int num = 0;
        while (!canceled && num <= 100000000) {
            if (num % 10 == 0) {
                System.out.println(num + "是10的倍数。");
            }
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop r = new VolatileCanStop();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(3000);
        r.canceled = true;
    }
}

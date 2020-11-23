package com.xima.thread.practice.thread_demo.dead_lock;

public class MayDeadLock {

    private Object o1 = new Object();
    private Object o2 = new Object();

    public void thread1() throws InterruptedException {
        synchronized (o1) {
            Thread.sleep(500);
            synchronized (o2) {
                System.out.println("线程1成功拿到两把锁");
            }
        }
    }

    public void thread2() throws InterruptedException {
        synchronized (o2) {
            Thread.sleep(500);
            synchronized (o1) {
                System.out.println("线程2成功拿到两把锁");
            }
        }
    }

    public static void main(String[] args) {
        MayDeadLock mayDeadLock = new MayDeadLock();
        Runnable r1 = ()->{
            try {
                mayDeadLock.thread1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = ()->{
            try {
                mayDeadLock.thread2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r1).start();
        new Thread(r2).start();
    }


}

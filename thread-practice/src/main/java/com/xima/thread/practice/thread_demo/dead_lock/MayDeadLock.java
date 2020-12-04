package com.xima.thread.practice.thread_demo.dead_lock;


/**
 * step1.查看pid
 *  jps
 * 34465 KotlinCompileDaemon
 * 50883
 * 61669 Jps
 * 61624 KotlinCompileDaemon
 * 54746 Launcher
 * 61626 MayDeadLock
 * 61627 Launcher
 *
 * step2. jstack 61626
 * ....
 * Java stack information for the threads listed above:
 * ===================================================
 * "Thread-0":
 *         at com.xima.thread.practice.thread_demo.dead_lock.MayDeadLock.thread1(MayDeadLock.java:12)
 *         - waiting to lock <0x0000000787ed3578> (a java.lang.Object)
 *         - locked <0x0000000787ed3568> (a java.lang.Object)
 *         at com.xima.thread.practice.thread_demo.dead_lock.MayDeadLock.lambda$main$0(MayDeadLock.java:30)
 *         at com.xima.thread.practice.thread_demo.dead_lock.MayDeadLock$$Lambda$14/0x0000000800066840.run(Unknown Source)
 *         at java.lang.Thread.run(java.base@11.0.4/Thread.java:834)
 * "Thread-1":
 *         at com.xima.thread.practice.thread_demo.dead_lock.MayDeadLock.thread2(MayDeadLock.java:21)
 *         - waiting to lock <0x0000000787ed3568> (a java.lang.Object)
 *         - locked <0x0000000787ed3578> (a java.lang.Object)
 *         at com.xima.thread.practice.thread_demo.dead_lock.MayDeadLock.lambda$main$1(MayDeadLock.java:37)
 *         at com.xima.thread.practice.thread_demo.dead_lock.MayDeadLock$$Lambda$15/0x0000000800066c40.run(Unknown Source)
 *         at java.lang.Thread.run(java.base@11.0.4/Thread.java:834)
 *
 * Found 1 deadlock.
 *
 *
 */
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

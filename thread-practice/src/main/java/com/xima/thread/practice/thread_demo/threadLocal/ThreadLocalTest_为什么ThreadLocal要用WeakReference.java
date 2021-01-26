package com.xima.thread.practice.thread_demo.threadLocal;

import java.lang.ref.WeakReference;

public class ThreadLocalTest_为什么ThreadLocal要用WeakReference {

//    public static void main(String[] args) throws InterruptedException {
//        //我们在这里只插入一段模拟线程运行的情况    ……
//        ObjectPassing obj = new ObjectPassing();
//        obj.setName("name");
//        MyThread myThread = new MyThread(obj);//obj不是空的传入新线程
//        new Thread(myThread).start();//线程不停的打印obj的name字段值
//        Thread.sleep(1000);
//        obj = null;//将外面的obj置为空后，线程打印的仍然不为空，这点需要先明确
//        System.out.println("2:" + obj);
//
//        Thread.sleep(1000000);
//    }


    /**
     * 为什么ThreadLocal要用WeakReference
     *
     * 　我的理解就是，WeakReference对应用的对象ObjectPassing是弱引用，不会影响到ObjectPassing的GC行为。
     * 如果是强引用的话，在线程运行过程中，我们不再使用ObjectPassing了，将ObjectPassing置为null，
     * 但ObjectPassing在线程的ThreadLocalMap里还有引用，导致其无法被GC回收（当然，可以等到线程运行结束后，
     * 整个Map都会被回收，但很多线程要运行很久，如果等到线程结束，便会一直占着内存空间）。
     * 而Entry声明为WeakReference，ObjectPassing置为null后，线程的threadLocalMap就不算强引用了，
     * ObjectPassing就可以被GC回收了。map的后续操作中，也会逐渐把对应的"stale entry"清理出去，避免内存泄漏。
     *
     * 　　所以，我们在使用完ThreadLocal变量时，尽量用threadLocal.remove()来清除，
     * 避免threadLocal=null的操作。前者remove()会同时清除掉线程threadLocalMap里的entry，
     * 算是彻底清除；而后者虽然释放掉了threadLocal，但线种threadLocalMap里还有其"stale entry"，后续还需要处理。
     */
    public static void main(String[] args) {
        ObjectPassing obj = new ObjectPassing();
        obj.setName("name");
        WeakReference<ObjectPassing> weakReference = new WeakReference<>(obj);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(weakReference.get().getName());//1

        obj.setName("name2");
        System.out.println(weakReference.get().getName());//1

        obj = null;
        System.out.println(weakReference.get());//1

        System.gc();//遇到gc就回收了
        System.out.println(weakReference.get());//null
    }

    static class ObjectPassing {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

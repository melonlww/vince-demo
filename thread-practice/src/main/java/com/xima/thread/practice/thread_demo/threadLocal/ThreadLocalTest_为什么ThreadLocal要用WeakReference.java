package com.xima.thread.practice.thread_demo.threadLocal;

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


    public static void main(String[] args) {
        ThreadLocal local = new ThreadLocal();
        local.set("当前线程名称：" + Thread.currentThread().getName());//将ThreadLocal作为key放入threadLocals.Entry中
        Thread t = Thread.currentThread();//注意断点看此时的threadLocals.Entry数组刚设置的referent是指向Local的，referent就是Entry中的key只是被WeakReference包装了一下
        local = null;//断开强引用，即断开local与referent的关联，但Entry中此时的referent还是指向Local的，为什么会这样，当引用传递设置为null时无法影响传递内的结果
        System.gc();//执行GC
        t = Thread.currentThread();//这时Entry中referent是null了，被GC掉了，因为Entry和key的关系是WeakReference，并且在没有其他强引用的情况下就被回收掉了
//如果这里不采用WeakReference，即使local=null，那么也不会回收Entry的key，因为Entry和key是强关联
//但是这里仅能做到回收key不能回收value，如果这个线程运行时间非常长，即使referent GC了，value持续不清空，就有内存溢出的风险
//彻底回收最好调用remove
//即：local.remove();//remove相当于把ThreadLocalMap里的这个元素干掉了，并没有把自己干掉
        System.out.println(local);
    }

    public void testNullPassFunc(ObjectPassing obj) {
        obj = new ObjectPassing();
        obj.setName("zxp");
        System.out.println("2:" + obj);
    }

    public void testNullPassFunc2(ObjectPassing obj) {
        obj = null;
        System.out.println("2:" + obj);
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

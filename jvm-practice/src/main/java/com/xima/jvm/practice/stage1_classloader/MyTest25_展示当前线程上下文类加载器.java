package com.xima.jvm.practice.stage1_classloader;

public class MyTest25_展示当前线程上下文类加载器 implements Runnable{

    private Thread thread;

    public MyTest25_展示当前线程上下文类加载器() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("Class:"+classLoader.getClass());
        System.out.println("Class:"+classLoader.getParent().getClass());

    }

    public static void main(String[] args) {
        new MyTest25_展示当前线程上下文类加载器();
    }

}

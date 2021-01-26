package com.xima.thread.practice.thread_demo.threadLocal;

import java.lang.ref.WeakReference;

public class ThreadLocalTest {

    public static void main(String[] args) {

        WeakReference<Apple> weakReference = new WeakReference<>(new ThreadLocalTest.Apple("1"));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(weakReference.get());//1
        System.gc();//遇到gc就回收了
        System.out.println(weakReference.get());//null
    }

    public static class Apple {

        private String price;

        public Apple(String price) {
            this.price = price;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}

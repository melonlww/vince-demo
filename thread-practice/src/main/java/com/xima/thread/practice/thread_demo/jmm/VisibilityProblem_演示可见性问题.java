package com.xima.thread.practice.thread_demo.jmm;

/**
 * 描述：     演示可见性带来的问题
 *
 * 打印
 * ------------------
 * b=30;a=30
 * b=30;a=30
 * b=30;a=30
 * b=30;a=10
 * b=30;a=30
 *
 *
 * 出现b=30;a=10 就是发生可见性问题
 *
 */
public class VisibilityProblem_演示可见性问题 {
    int a = 10;
    int b = 20;

    private void change() {
        a = 30;
        b = a;
    }

    private void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    public static void main(String[] args) {
        while (true) {
            VisibilityProblem_演示可见性问题 problem = new VisibilityProblem_演示可见性问题();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    problem.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    problem.print();
                }
            }).start();
        }
    }
}
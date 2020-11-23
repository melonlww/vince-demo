package com.xima.jvm.practice.stage1_classloader;

public class MyPerson {
    static {
        System.out.println("invoke MyPerson static");
    }

    private MyPerson myPerson;

    public void setMyPersonObject(Object myPerson) {
        this.myPerson = (MyPerson) myPerson;
    }
}

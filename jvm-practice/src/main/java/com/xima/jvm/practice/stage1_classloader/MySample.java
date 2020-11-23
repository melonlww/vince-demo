package com.xima.jvm.practice.stage1_classloader;

public class MySample {

    public MySample(){
        System.out.println("MySample is loaded by:" + this.getClass().getClassLoader());

        new MyCat();
    }
}

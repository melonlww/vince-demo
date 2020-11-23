package com.xima.jvm.practice.stage1_classloader;

public class MyCat {

    public MyCat(){
        System.out.println("MyCat is loaded by:" + this.getClass().getClassLoader());
    }

}

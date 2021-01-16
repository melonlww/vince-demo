package com.xima.design.pattern.创建型.原型模式.s5深克隆;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeepPrototype_ArrayList implements Cloneable{

    private int age;

    private String name;

    private List<String> hobbies;

    /**
     * 根据里氏替换原则，不去改父类方法本身具有的含义，object中的clone本身就是浅克隆
     */
    @Override
    public DeepPrototype_ArrayList clone() {
        try {
            return (DeepPrototype_ArrayList)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ArrayList clone方法实现了深克隆
     * 需要(List)((ArrayList) 强转，硬编码，不太常用，而且List对象下如果是引用对象，还是潜克隆
     * @return
     */
    public DeepPrototype_ArrayList deepCloneArrayList() {
        try {
            DeepPrototype_ArrayList deepPrototype = (DeepPrototype_ArrayList)super.clone();
            deepPrototype.setHobbies((List)((ArrayList)this.hobbies).clone());
            return deepPrototype;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "DeepPrototype_ArrayList{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}

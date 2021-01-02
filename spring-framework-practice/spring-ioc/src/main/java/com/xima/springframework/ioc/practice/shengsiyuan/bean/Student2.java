package com.xima.springframework.ioc.practice.shengsiyuan.bean;

import org.springframework.beans.factory.BeanNameAware;

public class Student2 implements BeanNameAware {

    private String name;

    private int age;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    public void setBeanName(String beanName) {
        id = beanName;
    }
}

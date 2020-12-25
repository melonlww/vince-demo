package com.xima.springframework.shengsiyuan.practice.stage1.bean;

public class Student3{

    private String name;

    private int age;

    public Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

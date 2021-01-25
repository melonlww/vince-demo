package com.xima.design.pattern.创建型.原型模式_Prototype.s4浅克隆;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ShallowPrototype source = new ShallowPrototype();
        source.setAge(18);
        source.setName("li");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("体育");
        hobbies.add("音乐");
        source.setHobbies(hobbies);

        ShallowPrototype shallow = source.clone();
        /**
         * 克隆对象对其中引用类型的成员变量做修改时，会更改source对象中的变量
         * 因为浅克隆会共享引用变量
         */
        shallow.getHobbies().add("IT");

        System.out.println(source == shallow);
        System.out.println("原型对象：" + source);
        System.out.println("克隆对象：" + shallow);

        System.out.println(source.getHobbies() == shallow.getHobbies());
        System.out.println(source.getName() == shallow.getName());
        System.out.println(source.getAge() == shallow.getAge());
    }
}

package com.xima.design.pattern.创建型.原型模式.s5深克隆;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        DeepPrototype source = new DeepPrototype();
        source.setAge(18);
        source.setName("li");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("体育");
        hobbies.add("音乐");
        source.setHobbies(hobbies);

        DeepPrototype deep = source.deepClone();
        deep.getHobbies().add("IT");

        System.out.println(source == deep);
        System.out.println("原型对象：" + source);
        System.out.println("克隆对象：" + deep);

        System.out.println(source.getHobbies() == deep.getHobbies());
        System.out.println(source.getName() == deep.getName());
        System.out.println(source.getAge() == deep.getAge());
    }
}

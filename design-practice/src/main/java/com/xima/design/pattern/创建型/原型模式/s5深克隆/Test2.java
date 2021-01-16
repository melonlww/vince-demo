package com.xima.design.pattern.创建型.原型模式.s5深克隆;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        DeepPrototype_ArrayList source = new DeepPrototype_ArrayList();
        source.setAge(18);
        source.setName("li");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("体育");
        hobbies.add("音乐");
        source.setHobbies(hobbies);

        DeepPrototype_ArrayList deep = source.deepCloneArrayList();
        deep.getHobbies().add("朗诵");

        System.out.println(source == deep);
        System.out.println("原型对象：" + source);
        System.out.println("克隆对象：" + deep);

        System.out.println(source.getHobbies() == deep.getHobbies());
        System.out.println(source.getName() == deep.getName());
        System.out.println(source.getAge() == deep.getAge());
    }
}

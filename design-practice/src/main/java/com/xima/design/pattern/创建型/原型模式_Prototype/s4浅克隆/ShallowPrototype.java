package com.xima.design.pattern.创建型.原型模式_Prototype.s4浅克隆;

import java.util.List;

public class ShallowPrototype implements Cloneable {

    private int age;

    private String name;

    private List<String> hobbies;

    /**
     * @HotSpotIntrinsicCandidate
     *     protected native Object clone() throws CloneNotSupportedException;
     * @return
     */
    @Override
    public ShallowPrototype clone() {
        try {
            return (ShallowPrototype)super.clone();
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
        return "ShallowPrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}

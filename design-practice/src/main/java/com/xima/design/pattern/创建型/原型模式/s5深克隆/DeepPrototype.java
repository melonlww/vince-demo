package com.xima.design.pattern.创建型.原型模式.s5深克隆;

import com.xima.design.pattern.创建型.单例模式.破坏单例模式.序列化.SerializableSingleton;

import java.io.*;
import java.util.List;

public class DeepPrototype implements Cloneable,Serializable {

    private int age;

    private String name;

    private List<String> hobbies;

    /**
     * 根据里氏替换原则，不去改父类方法本身具有的含义，object中的clone本身就是浅克隆
     */
    @Override
    public DeepPrototype clone() {
        try {
            return (DeepPrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DeepPrototype deepClone(){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            DeepPrototype obj = (DeepPrototype)ois.readObject();
            bos.close();
            bis.close();
            return obj;
        } catch (Exception e) {
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
        return "DeepPrototype{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}

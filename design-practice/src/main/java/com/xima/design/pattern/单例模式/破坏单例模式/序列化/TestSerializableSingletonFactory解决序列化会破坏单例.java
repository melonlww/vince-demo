package com.xima.design.pattern.单例模式.破坏单例模式.序列化;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SerializableSingleton类中 增加readResolve方法
 *
 * 原理
 * ObjectInputStream#readObject 中会调用 desc.hasReadResolveMethod() --> readResolveMethod.invoke(obj, (Object[]) null);
 * 如果类中有readResolve这个方法，则会调用
 *
 */
public class TestSerializableSingletonFactory解决序列化会破坏单例 {
    public static void main(String[] args) {
        SerializableSingleton解决序列化会破坏单例 s1 = SerializableSingleton解决序列化会破坏单例.getInstance();
        SerializableSingleton解决序列化会破坏单例 s2;

        try{
            //生成到项目目录下 Users/xmly/practice/code/vince-demo/SerializableSingleton.obj
            FileOutputStream fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SerializableSingleton解决序列化会破坏单例)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


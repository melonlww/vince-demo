package com.xima.design.pattern.创建型.单例模式.破坏单例模式.序列化;

import java.io.*;

/**
 * 序列化：
 * 把内存中对象的状态转换为字节码的形式
 * 把字节码通过IO输出流，写到磁盘上
 * 永久保存下来，持久化
 *
 * 反序列化：
 * 将持久化的字节码内容，通过IO输入流读到内存中来
 * 转化成一个Java对象
 */
public class TestSerializableSingletonFactory {
    public static void main(String[] args) {
        SerializableSingleton s1 = SerializableSingleton.getInstance();
        SerializableSingleton s2;

        try{
            //生成到项目目录下 Users/xmly/practice/code/vince-demo/SerializableSingleton.obj
            FileOutputStream fos = new FileOutputStream("SerializableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SerializableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s2 = (SerializableSingleton)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


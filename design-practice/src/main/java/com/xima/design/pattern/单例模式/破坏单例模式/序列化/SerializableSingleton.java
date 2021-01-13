package com.xima.design.pattern.单例模式.破坏单例模式.序列化;

import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    public final static SerializableSingleton instance = new SerializableSingleton();

    private SerializableSingleton(){}

    public static SerializableSingleton getInstance(){
        return instance;
    }
}

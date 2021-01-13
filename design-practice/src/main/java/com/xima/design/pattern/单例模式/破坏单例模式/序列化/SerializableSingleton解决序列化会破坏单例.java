package com.xima.design.pattern.单例模式.破坏单例模式.序列化;

import java.io.Serializable;

/**
 * 增加readResolve方法
 */
public class SerializableSingleton解决序列化会破坏单例 implements Serializable {

    public final static SerializableSingleton解决序列化会破坏单例 instance = new SerializableSingleton解决序列化会破坏单例();

    private SerializableSingleton解决序列化会破坏单例(){}

    public static SerializableSingleton解决序列化会破坏单例 getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}

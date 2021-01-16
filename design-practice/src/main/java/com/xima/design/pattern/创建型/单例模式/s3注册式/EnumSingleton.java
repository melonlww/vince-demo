package com.xima.design.pattern.创建型.单例模式.s3注册式;

public enum EnumSingleton {

    instance;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return instance;
    }
}

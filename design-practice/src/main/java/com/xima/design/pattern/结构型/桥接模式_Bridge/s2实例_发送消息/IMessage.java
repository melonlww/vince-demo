package com.xima.design.pattern.结构型.桥接模式_Bridge.s2实例_发送消息;

public interface IMessage {
    //发送消息的内容和接收对象
    void send(String message, String toUser);
}

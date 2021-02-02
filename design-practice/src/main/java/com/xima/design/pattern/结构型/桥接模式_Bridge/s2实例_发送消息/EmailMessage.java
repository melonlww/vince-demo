package com.xima.design.pattern.结构型.桥接模式_Bridge.s2实例_发送消息;

public class EmailMessage implements IMessage {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件消息发送" + message + "给" + toUser);
    }
}

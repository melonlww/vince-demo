package com.xima.design.pattern.结构型.桥接模式_Bridge.s2实例_发送消息;

public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    void sendMessage(String message, String toUser) {
        message = "[加急！！！]" + message;
        super.sendMessage(message, toUser);
    }
}

package com.xima.design.pattern.结构型.桥接模式_Bridge.s2实例_发送消息;

public abstract class AbstractMessage {
    private IMessage message;

    public AbstractMessage(IMessage message) {
        this.message = message;
    }

    void sendMessage(String message, String toUser) {
        this.message.send(message, toUser);
    }

}

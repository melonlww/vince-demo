package com.xima.design.pattern.结构型.桥接模式_Bridge.s2实例_发送消息;

public class NormalMessage extends AbstractMessage {
    public NormalMessage(IMessage message) {
        super(message);
    }

}

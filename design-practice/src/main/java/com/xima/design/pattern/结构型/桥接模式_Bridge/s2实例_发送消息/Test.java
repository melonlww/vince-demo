package com.xima.design.pattern.结构型.桥接模式_Bridge.s2实例_发送消息;

public class Test {

    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage("加班申请", "王sir");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("加班申请", "王sir");
    }
}

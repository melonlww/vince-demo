package com.xima.design.pattern.行为型.中介者模式_Mediator.s2实例_聊天室;

public class ChatRoom {

    public void showMsg(User user, String msg) {
        System.out.println("[" + user.getName() + "]发送消息：" + msg);
    }
}

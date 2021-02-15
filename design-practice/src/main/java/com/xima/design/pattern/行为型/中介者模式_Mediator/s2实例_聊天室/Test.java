package com.xima.design.pattern.行为型.中介者模式_Mediator.s2实例_聊天室;

public class Test {

    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User tom = new User("tom", chatRoom);
        User li = new User("li", chatRoom);

        tom.sendMessage("Hello, my name is tom");
        li.sendMessage("Hello my name is li");
    }
}

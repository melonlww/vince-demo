package com.xima.spring.boot.event.publisher.event;

import com.xima.spring.boot.event.publisher.entity.User;
import org.springframework.context.ApplicationEvent;


public class UserRegisterEvent extends ApplicationEvent {
    private static final long serialVersionUID = -5481658020206295565L;
    private User user;

    //谁发布的这个事件，source就是谁（对象）
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
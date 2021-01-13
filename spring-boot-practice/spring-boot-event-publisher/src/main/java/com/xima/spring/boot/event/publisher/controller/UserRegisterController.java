package com.xima.spring.boot.event.publisher.controller;

import com.xima.spring.boot.event.publisher.entity.User;
import com.xima.spring.boot.event.publisher.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserRegisterController {
    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping("/register")
    public String register(User user) {
        //进行注册
        userRegisterService.register(user);
        return "[controller]注册用户成功！";
    }
}
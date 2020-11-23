package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 操作
 * 1.进入target目录
 * 2.java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar spring-webmvc-1.0-SNAPSHOT-war-exec.jar
 *
 *
 * HelloWorld {@link Controller}
 *
 * @since 2018/5/20
 */
@Controller
public class HelloWorld2Controller {

    @RequestMapping("/hello2")
    public String index(@RequestParam int value, Model model) {
        return "index";
    }

}

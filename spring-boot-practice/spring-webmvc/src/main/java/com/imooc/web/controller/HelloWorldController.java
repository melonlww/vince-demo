package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
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
public class HelloWorldController {

    /* //实验一 返回jsp模板
    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }*/

   /* //实验二 在方法参数内获取参数
    @RequestMapping("")
    public String index(@RequestHeader("Accept-Language") String acceptLanguage,
                        @CookieValue("JSESSIONID") String jsessionId,
                        Model model) {
        model.addAttribute("acceptLanguage",acceptLanguage);
        model.addAttribute("jsessionId",jsessionId);
        model.addAttribute("message","Hello,World");
        return "index";
    }*/

    //实验三 通过 注册模型属性： @ModelAttribute
    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("jsessionId")
    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId){
        return jsessionId;
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello,World3";
    }

}

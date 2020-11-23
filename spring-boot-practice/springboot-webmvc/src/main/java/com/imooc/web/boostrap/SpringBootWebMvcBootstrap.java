package com.imooc.web.boostrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.io.File;


/**
 * Spring Boot Web MVC 引导类
 * 操作
 * 1.进入target目录
 *      cd ~/practice/code/vince-practice/spring-boot-practice/springboot-webmvc/target
 * 2.java -jar  springboot-webmvc-1.0-SNAPSHOT.war
 *
 * @since 2018/5/21
 */
@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootWebMvcBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class, args);
    }

}

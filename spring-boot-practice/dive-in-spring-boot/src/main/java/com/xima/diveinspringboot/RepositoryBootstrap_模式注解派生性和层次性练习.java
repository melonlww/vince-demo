package com.xima.diveinspringboot;

import com.xima.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用注解：@FirstLevelRepository 和 @SecondLevelRepository 展示"模式注解"的“派生性”和“层次性”
 */
@ComponentScan("com.xima.diveinspringboot.repository")
public class RepositoryBootstrap_模式注解派生性和层次性练习 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap_模式注解派生性和层次性练习.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //myFirstLevelRepository Bean是否存在
        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        System.out.println("myFirstLevelRepository bean：" + myFirstLevelRepository);


        context.close();
    }
}

package com.xima.diveinspringboot;

import com.xima.diveinspringboot.service.CalculateService;
import com.xima.diveinspringboot.service.Java7CalculateService;
import com.xima.diveinspringboot.service.Java8CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * {@link CalculateService}引导类
 * 实现类 {@link Java7CalculateService} 和 {@link Java8CalculateService}通过 @Profile 定义profile value
 * 根据profile值判断是否加载bean
 */
@SpringBootApplication(scanBasePackages = "com.xima.diveinspringboot.service")
public class CalculateServiceBootstrap_Profile注解练习 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap_Profile注解练习.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);
        CalculateService calculateService =  context.getBean(CalculateService.class);
        System.out.println("calculateService.sum(1...5) "+calculateService.sum(1,2,3,4,5));

        System.out.println("beans:");
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        context.close();
    }
}

package com.xima.springframework.ioc.practice.mashibin.aop;

import com.xima.springframework.ioc.practice.mashibin.bean.IPerson;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {IPerson.class, BuyAspectJ.class })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
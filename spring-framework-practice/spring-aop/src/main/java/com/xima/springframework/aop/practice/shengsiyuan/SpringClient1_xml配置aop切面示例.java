package com.xima.springframework.aop.practice.shengsiyuan;

import com.xima.springframework.aop.practice.shengsiyuan.service.MyService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringClient1_xml配置aop切面示例 {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext.xml");
        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 工厂装配完毕， 获取bean对象
        MyService myService = (MyService) defaultListableBeanFactory.getBean("myAop");
        myService.myMethod();

        //打印bean的父类  class java.lang.reflect.Proxy
        System.out.println(myService.getClass().getSuperclass());

        //打印bean实现的接口
//        interface com.xima.springframework.aop.practice.shengsiyuan.service.MyService
//        interface org.springframework.aop.SpringProxy
//        interface org.springframework.aop.framework.Advised
//        interface org.springframework.core.DecoratingProxy
        for(int i =0;i<myService.getClass().getInterfaces().length;i++){
            System.out.println(myService.getClass().getInterfaces()[i]);
        }
    }
}

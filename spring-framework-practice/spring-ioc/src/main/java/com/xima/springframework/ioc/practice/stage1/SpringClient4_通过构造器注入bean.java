package com.xima.springframework.ioc.practice.stage1;

import com.xima.springframework.ioc.practice.stage1.bean.Student3;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * applicationContext3.xml中通过构造器注入
 *
 */
public class SpringClient4_通过构造器注入bean {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext3.xml");
        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 工厂装配完毕， 获取bean对象
        Student3 student = (Student3) defaultListableBeanFactory.getBean("student3");
        System.out.println(student);

    }
}

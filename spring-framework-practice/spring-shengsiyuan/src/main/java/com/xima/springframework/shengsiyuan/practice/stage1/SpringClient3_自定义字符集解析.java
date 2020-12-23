package com.xima.springframework.shengsiyuan.practice.stage1;

import com.xima.springframework.shengsiyuan.practice.stage1.bean.Student;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * GBK字符集解析
 */
public class SpringClient3_自定义字符集解析 {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext.xml");
        EncodedResource encodedResource = new EncodedResource(resource, "GBK");

        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        XmlBeanDefinitionReader XmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        XmlBeanDefinitionReader.loadBeanDefinitions(encodedResource);

        // 工厂装配完毕， 获取bean对象
        Student student = (Student) defaultListableBeanFactory.getBean("student");
        System.out.println(student);

    }
}

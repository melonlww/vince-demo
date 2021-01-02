package com.xima.springframework.ioc.practice.stage1;

import com.xima.springframework.ioc.practice.stage1.bean.Student2;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @see Student2 implements BeanNameAware
 *
 * aware,翻译过来是知道的，已感知的，意识到的，所以这些接口从字面意思应该是能感知到所有Aware前面的含义。
 * BeanNameAware让自身Bean能够感知到，获取到自身在Spring容器中的id属性
 *
 * 同理，其他的Aware接口也是为了能够感知到自身的一些属性。
 * 比如实现了ApplicationContextAware接口的类，能够获取到ApplicationContext，实现了BeanFactoryAware接口的类，能够获取到BeanFactory对象。
 *
 */
public class SpringClient2_Aware接口的作用 {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext2.xml");
        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        Student2 student2 = (Student2) defaultListableBeanFactory.getBean("student2");
        System.out.println(student2);

    }
}

package com.xima.springframework.ioc.practice.shengsiyuan;

import com.xima.springframework.ioc.practice.shengsiyuan.bean.Student4;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 一个bean中引用了另一个bean，解析PropertyValue时，会走到resolveReference方法，加载被引用的bean
 *
 * Resolve a reference to another bean in the factory.
 *
 * BeanDefinitionValueResolver#resolveValueIfNecessary(Object argName, @Nullable Object value) {
 * 		if (value instanceof RuntimeBeanReference) {
 * 			RuntimeBeanReference ref = (RuntimeBeanReference) value;
 * 			return resolveReference(argName, ref);
 *      }
 *
 */
public class SpringClient6_bean中引用其他bean {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext4.xml");
        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 工厂装配完毕， 获取bean对象
        Student4 student4 = (Student4) defaultListableBeanFactory.getBean("student4");
        System.out.println(student4);

    }
}

package com.xima.springframework.ioc.practice.shengsiyuan;

import com.xima.springframework.ioc.practice.shengsiyuan.bean.Student;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * getBean方法用到反射时，当配置文件中的属性名为name2，spring根据PropertyDescriptor会根据java bean规范的命名规定
 * 从writeMethodName获取值为setName2()的方法， 获取不到时则抛出异常
 *
 * CachedIntrospectionResults 缓存java内省（内部结构）结果
 * BeanWrapperImpl#getCachedIntrospectionResults方法：
 *      this.cachedIntrospectionResults = CachedIntrospectionResults.forClass(getWrappedClass());
 *
 */
public class SpringClient7_配置错误的属性名 {

    public static void main(String[] args) {
        //1.定义一个资源
        Resource resource = new ClassPathResource("applicationContext5.xml");
        //2.定义一个工厂         XmlBeanFactory为DefaultListableBeanFactory的子类，太具体，只能加载xml文件，已经遭spring弃用
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        //3.定义一个bean读取器，将读取好的内容放到工厂当中，由工厂进行bean统一的管理    读取器-->工厂
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        //4.定义好从指定资源中读取      读取器-->资源
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 工厂装配完毕， 获取bean对象
        Student student = (Student) defaultListableBeanFactory.getBean("student");
        System.out.println(student);

    }
}

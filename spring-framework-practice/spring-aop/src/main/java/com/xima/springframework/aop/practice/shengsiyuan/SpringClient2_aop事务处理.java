package com.xima.springframework.aop.practice.shengsiyuan;

import com.xima.springframework.aop.practice.shengsiyuan.transaction.bean.Student;
import com.xima.springframework.aop.practice.shengsiyuan.transaction.service.StudentService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * jvm参数
 * -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
 */
public class SpringClient2_aop事务处理 {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext2.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        StudentService studentService = (StudentService) defaultListableBeanFactory.getBean("studentServiceProxy");

        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(20);

        studentService.saveStudent(student);
    }
}

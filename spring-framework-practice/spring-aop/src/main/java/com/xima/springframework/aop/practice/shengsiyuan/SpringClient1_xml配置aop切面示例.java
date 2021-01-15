package com.xima.springframework.aop.practice.shengsiyuan;

import com.xima.springframework.aop.practice.shengsiyuan.service.MyService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * BeanFactory是Spring IOC的工厂，它里面管理者Spring所创建出来的各种Bean对象，当我们在配置文件（注解）中声明了某个bean的id后，通过
 * 这个id就可以获取到与该id所对应的class对象的实例（可能新建，也可能从缓存中获取）
 *
 * FactoryBean本质上也是一个Bean，它同其他Bean一样，也是由BeanFactory所管理和维护的，当然它的实例也会缓存到Spring的工厂中（如果是单例），
 * 它与普通的Bean的位于区别在于，当Spring创建一个FactoryBean的实例后，它接下来会判断当前所创建的Bean是否是一个FactoryBean实例，如果不是，
 * 那么就直接将创建出来的Bean返回给客户端；如果是，那么它会对其进行进一步的处理，根据配置文件所配置的target，advisor与interfaces等
 * 信息，在运行期动态创建出一个类，并生成该类的一个实例，最后将该实例返回给客户端；因此，我们在声明一个FactoryBean时，通过id获取到的并非
 * 这个FactoryBean的实例，而是它动态生成出来的一个代理对象（通过三种方式来进行生成 JdkDynamicAopProxy，CglibAopProxy，ObjenesisCglibAopProxy）
 */
public class SpringClient1_xml配置aop切面示例 {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        MyService myService = (MyService) defaultListableBeanFactory.getBean("myAop");
        myService.myMethod();

        myService.myMethod2();

        //打印bean的父类  class java.lang.reflect.Proxy
        System.out.println(myService.getClass().getSuperclass());

        /**
         * 打印bean实现的接口    AopProxyUtils#completeProxiedInterfaces方法中实现了在调用Proxy.newProxyInstance前增加了这几个接口，SpringProxy，Advised，DecoratingProxy
         *
         * interface com.xima.springframework.aop.practice.shengsiyuan.service.MyService
         * interface org.springframework.aop.SpringProxy
         * interface org.springframework.aop.framework.Advised
         * interface org.springframework.core.DecoratingProxy
         */
        for(int i =0;i<myService.getClass().getInterfaces().length;i++){
            System.out.println(myService.getClass().getInterfaces()[i]);
        }
    }
}

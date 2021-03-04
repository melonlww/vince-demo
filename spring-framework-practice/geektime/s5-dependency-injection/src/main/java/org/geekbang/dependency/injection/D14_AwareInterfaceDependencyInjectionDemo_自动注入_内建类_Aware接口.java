package org.geekbang.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 {@link Aware} 接口回调的依赖注入示例
 *
 */
public class D14_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_Aware接口 implements BeanFactoryAware, ApplicationContextAware {

    //static只是为了简化开发， 不影响演示结果
    private static BeanFactory beanFactory;

    private static ApplicationContext applicationContext;


    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        context.register(D14_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_Aware接口.class);

        // 启动 Spring 应用上下文
        context.refresh();

        System.out.println(beanFactory == context.getBeanFactory());
        System.out.println(applicationContext == context);

        // 显示地关闭 Spring 应用上下文
        context.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        D14_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_Aware接口.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        D14_AwareInterfaceDependencyInjectionDemo_自动注入_内建类_Aware接口.applicationContext = applicationContext;
    }
}

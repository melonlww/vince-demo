package org.geekbang.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * 依赖来源示例， 这些内建bean是 "非spring容器管理对象"
 *
 * 内建bean依赖来源：
 * {@link AbstractApplicationContext} -> refresh() -> prepareBeanFactory(beanFactory);
 *
 *
 * beanFactory.registerResolvableDependency(BeanFactory.class, beanFactory);
 * beanFactory.registerResolvableDependency(ResourceLoader.class, this);
 * beanFactory.registerResolvableDependency(ApplicationEventPublisher.class, this);
 * beanFactory.registerResolvableDependency(ApplicationContext.class, this);
 *
 *
 */
public class D1_DependencySourceDemo_展示内建bean依赖来源 {

    /**
     *  注入在 postProcessProperties 方法执行，早于 setter注入，也早于 @PostConstruct
     */
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void initByInjection() {
        System.out.println("beanFactory == applicationContext " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory() " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("resourceLoader == applicationContext " + (resourceLoader == applicationContext));
        System.out.println("ApplicationEventPublisher == applicationContext " + (applicationEventPublisher == applicationContext));
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D1_DependencySourceDemo_展示内建bean依赖来源.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 DependencySourceDemo Bean
        D1_DependencySourceDemo_展示内建bean依赖来源 demo = applicationContext.getBean(D1_DependencySourceDemo_展示内建bean依赖来源.class);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
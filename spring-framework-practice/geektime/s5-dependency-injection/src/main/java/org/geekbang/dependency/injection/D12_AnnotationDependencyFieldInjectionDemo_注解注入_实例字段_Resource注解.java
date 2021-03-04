package org.geekbang.dependency.injection;

import org.geekbang.dependency.injection.domain.UserHolder;
import org.geekbang.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 基于 Java 注解的依赖字段注入示例
 *
 */
public class D12_AnnotationDependencyFieldInjectionDemo_注解注入_实例字段_Resource注解 {

    @Autowired
    private UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D12_AnnotationDependencyFieldInjectionDemo_注解注入_实例字段_Resource注解.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context4.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 AnnotationDependencyFieldInjectionDemo Bean,  Config类也是一个SpringBean
        D12_AnnotationDependencyFieldInjectionDemo_注解注入_实例字段_Resource注解 demo = applicationContext.getBean(D12_AnnotationDependencyFieldInjectionDemo_注解注入_实例字段_Resource注解.class);
        System.out.println(demo);

        // @Autowired 字段关联
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        // @Resource 字段关联
        System.out.println(demo.userHolder2);
        /**
         * @Autowired 注解注入的bean和 @Resource 注解注入的bean比较， 因为是单例模式，返回true
         */
        System.out.println(demo.userHolder == demo.userHolder2);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }
}

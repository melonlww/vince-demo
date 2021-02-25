package org.geekbang.dependency.lookup;

import org.geekbang.ioc.overview.domain.User2;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过 {@link ObjectProvider} 进行依赖查找
 *
 */
public class D6_ObjectProviderDemo_通过ObjectProvider_延迟查找接口_当查找的Bean不存在时的处理 { // @Configuration 是非必须注解

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
        applicationContext.register(D6_ObjectProviderDemo_通过ObjectProvider_延迟查找接口_当查找的Bean不存在时的处理.class);
        // 启动应用上下文
        applicationContext.refresh();

        lookupIfAvailable(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 如果当前容器中没有User类型的bean，就创建一个（兜底）
     * @param applicationContext
     */
    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User2> userObjectProvider = applicationContext.getBeanProvider(User2.class);
        User2 user = userObjectProvider.getIfAvailable(User2::createUser);
        System.out.println("当前 User 对象：" + user);
    }
}

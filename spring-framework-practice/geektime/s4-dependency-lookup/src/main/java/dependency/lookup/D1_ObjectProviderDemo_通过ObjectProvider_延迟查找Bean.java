package dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过 {@link ObjectProvider} 进行依赖查找
 *
 */
public class D1_ObjectProviderDemo_通过ObjectProvider_延迟查找Bean { // @Configuration 是非必须注解

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 ObjectProviderDemo 作为配置类（Configuration Class）
        applicationContext.register(D1_ObjectProviderDemo_通过ObjectProvider_延迟查找Bean.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupByObjectProvider(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

    @Bean
    public String helloWorld() { // 方法名就是 Bean 名称 = "helloWorld"
        return "Hello,World";
    }
}

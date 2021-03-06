/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.geekbang.dependency.injection;

import org.geekbang.ioc.overview.domain.User5;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * {@link ObjectProvider} 实现延迟依赖注入
 *
 * @since
 */
@Configuration
public class D22_LazyAnnotationDependencyInjectionDemo_延迟依赖注入 {

    @Autowired
    private User5 user; // 实时注入

    @Autowired
    @Qualifier("user")
    private User5 qualifiedUser; // 实时注入

    @Autowired
    private ObjectProvider<User5> userObjectProvider; // 延迟注入

    @Autowired
    private ObjectFactory<Set<User5>> usersObjectFactory;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D22_LazyAnnotationDependencyInjectionDemo_延迟依赖注入.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context7.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        D22_LazyAnnotationDependencyInjectionDemo_延迟依赖注入 demo = applicationContext.getBean(D22_LazyAnnotationDependencyInjectionDemo_延迟依赖注入.class);

        // 期待输出 superUser Bean
        System.out.println("demo.user = " + demo.user);
        // 期待输出 user Bean
        System.out.println("demo.qualifiedUser = " + demo.qualifiedUser);
        // 期待输出 superUser Bean
        System.out.println("demo.userObjectProvider 单个 = " + demo.userObjectProvider.getObject()); // 继承 ObjectFactory
        // 期待输出 superUser user Beans
        System.out.println("demo.userObjectProvider 多个=");
        demo.userObjectProvider.forEach(System.out::println);

        // 期待输出 superUser user Beans       usersObjectFactory 定义了泛型 Set<User5>
        System.out.println("demo.usersObjectFactory = " + demo.usersObjectFactory.getObject());



        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

}

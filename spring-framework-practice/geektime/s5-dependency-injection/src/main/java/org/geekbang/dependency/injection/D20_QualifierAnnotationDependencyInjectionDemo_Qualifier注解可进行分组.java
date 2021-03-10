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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * {@link Qualifier} 注解依赖注入
 *
 *  整体应用上下文存在 4 个 User 类型的 Bean:
 *     superUser
 *     user
 *     user1 -> @Qualifier
 *     user2 -> @Qualifier
 *
 *
 *  通过 Qualifier 实现分组限定，
 *
 *   @Autowired
 *     private Collection<User5> allUsers;  注入没有@Qualifier注解的  包括 @Qualifier("user")
 *
 *   @Autowired
 *   @Qualifier
 *     private Collection<User5> qualifiedUsers;    注入有@Qualifier注解的   不包括 @Qualifier("user")
 *
 *   @Autowired
 *   @Qualifier("user")
 *    private Collection<User5> qualifiedNamedUsers;    注入有@Qualifier("user")注解的
 *
 *
 *
 *
 */
public class D20_QualifierAnnotationDependencyInjectionDemo_Qualifier注解可进行分组 {

    /**
     * superUser -> primary =true
     */
    @Autowired
    private User5 user;

    /**
     * 指定 Bean 名称或 ID
     */
    @Autowired
    @Qualifier("user")
    private User5 namedUser;

    /**
     * 进行逻辑分组
     */
    @Bean
    @Qualifier
    public User5 user1() {
        return createUser(7L);
    }

    @Bean
    @Qualifier
    public User5 user2() {
        return createUser(8L);
    }

    /**
     * 2 Beans = user + superUser
     */
    @Autowired
    private Collection<User5> allUsers;

    /**
     * 2 Beans = user1 + user2
     */
    @Autowired
    @Qualifier
    private Collection<User5> qualifiedUsers;


    /**
     * 1 Beans = user
     */
    @Autowired
    @Qualifier("user")
    private Collection<User5> qualifiedNamedUsers;



    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D20_QualifierAnnotationDependencyInjectionDemo_Qualifier注解可进行分组.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context7.xml";
        // 加载 XML 资源，解析并且生成 BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        D20_QualifierAnnotationDependencyInjectionDemo_Qualifier注解可进行分组 demo = applicationContext.getBean(D20_QualifierAnnotationDependencyInjectionDemo_Qualifier注解可进行分组.class);

        /**
         * 期待输出 superUser Bean
         */
        System.out.println("demo.user = " + demo.user);
        /**
         * 期待输出 user Bean
         */
        System.out.println("demo.namedUser = " + demo.namedUser);


        /**
         * 期待输出 user superUser user1 user2 -> 实际输出 user + superUser 没有@Qualifier注解的  包括 @Qualifier("user")
         */
        System.out.println("demo.allUsers = " + demo.allUsers);
        /**
         *  期待输出 user1 user2 -> 实际输出 user1 + user2    有@Qualifier注解的  不包括 @Qualifier("user")
         */
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);

        /**
         * 实际输出 user    有@Qualifier("user")注解的
         */
        System.out.println("demo.qualifiedNamedUsers = " + demo.qualifiedNamedUsers);


        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static User5 createUser(Long id) {
        User5 user = new User5();
        user.setId(id);
        return user;
    }

}

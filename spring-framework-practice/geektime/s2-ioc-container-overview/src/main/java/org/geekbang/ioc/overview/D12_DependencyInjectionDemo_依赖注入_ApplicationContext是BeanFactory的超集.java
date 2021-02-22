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
package org.geekbang.ioc.overview;

import org.geekbang.ioc.overview.repository.UserRepository4;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * class AbstractRefreshableApplicationContext{
 *      @Nullable
 *      private DefaultListableBeanFactory beanFactory;
 * }
 * 上下文中组合了一个beanFactory  在接口中又是一个is的关系
 *
 *
 * ApplicationContext 除了IoC容器角色，还有提供：
 *      面向切面（AOP）
 *      配置元信息（Configuration Metadata）
 *      资源管理（Resources）
 *      事件（Events）
 *      国际化（i18n）
 *      注解（Annotations）
 *      Environment抽象（Environment Abstraction）
 *
 */
public class D12_DependencyInjectionDemo_依赖注入_ApplicationContext是BeanFactory的超集 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context5.xml");

        // 依赖来源一：自定义 Bean
        UserRepository4 userRepository = applicationContext.getBean("userRepository", UserRepository4.class);

        whoIsIoCContainer(userRepository, applicationContext);
    }

    private static void whoIsIoCContainer(UserRepository4 userRepository, ApplicationContext applicationContext) {

        //false     这个表达式为什么不会成立?
        System.out.println(userRepository.getBeanFactory() == applicationContext);

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
        // ConfigurableApplicationContext#getBeanFactory()

        //true      ApplicationContext is BeanFactory
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        System.out.println(userRepository.getBeanFactory() == configurableApplicationContext.getBeanFactory());

    }


}

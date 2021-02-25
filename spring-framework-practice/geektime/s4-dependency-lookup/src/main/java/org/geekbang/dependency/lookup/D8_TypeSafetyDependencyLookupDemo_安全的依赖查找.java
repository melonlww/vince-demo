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
package org.geekbang.dependency.lookup;

import org.geekbang.ioc.overview.domain.User2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 类型安全 依赖查找示例
 *  小马哥推荐使用ObjectProvider去查找Bean，支持单个和集合
 */
public class D8_TypeSafetyDependencyLookupDemo_安全的依赖查找 {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 TypeSafetyDependencyLookupDemo 作为配置类（Configuration Class）
        applicationContext.register(D8_TypeSafetyDependencyLookupDemo_安全的依赖查找.class);
        // 启动应用上下文
        applicationContext.refresh();

        /**
         * 演示 BeanFactory#getBean 方法的安全性  单个bean查找
         * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.geekbang.ioc.overview.domain.User2' available
         */
        displayBeanFactoryGetBean(applicationContext);

        /**
         * 演示 ObjectFactory#getObject 方法的安全性  单个bean查找
         * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.geekbang.ioc.overview.domain.User2' available
         */
        displayObjectFactoryGetObject(applicationContext);

        /**
         * 演示 ObjectProvider#getIfAvaiable 方法的安全性  单个bean查找
         * 不报错
         */
        displayObjectProviderIfAvailable(applicationContext);

        /**
         * 演示 BeanFactoryUtils#beanOfTypeIncludingAncestors 方法的安全性  单个bean查找
         * org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.geekbang.ioc.overview.domain.User2' available
         */
        displayBeanFactoryUtilsBeanOfTypeIncludingAncestor(applicationContext);

        /**
         * 演示 ListableBeanFactory#getBeansOfType 方法的安全性  集合bean查找
         * 不报错
         */
        displayListableBeanFactoryGetBeansOfType(applicationContext);

        /**
         * 演示 ObjectProvider Stream 操作的安全性  集合bean查找
         * 不报错
         */
        displayObjectProviderStreamOps(applicationContext);

        /**
         * 演示 BeanFactoryUtils#displayBeanFactoryUtilsBeansOfTypeIncludingAncestor 方法的安全性  集合bean查找
         * 不报错
         */
        displayBeanFactoryUtilsBeansOfTypeIncludingAncestor(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeansException("displayBeanFactoryGetBean", () -> beanFactory.getBean(User2.class));
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        // ObjectProvider is ObjectFactory
        ObjectFactory<User2> userObjectFactory = applicationContext.getBeanProvider(User2.class);
        printBeansException("displayObjectFactoryGetObject", () -> userObjectFactory.getObject());
    }

    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User2> User2ObjectProvider = applicationContext.getBeanProvider(User2.class);
        printBeansException("displayObjectProviderIfAvailable", () -> User2ObjectProvider.getIfAvailable());
    }

    private static void displayBeanFactoryUtilsBeanOfTypeIncludingAncestor(AnnotationConfigApplicationContext applicationContext) {
        printBeansException("displayBeanFactoryUtilsBeanOfTypeIncludingAncestor", () -> BeanFactoryUtils.beanOfTypeIncludingAncestors(applicationContext, User2.class));
    }

    private static void displayListableBeanFactoryGetBeansOfType(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactoryGetBeansOfType", () -> beanFactory.getBeansOfType(User2.class));
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User2> User2ObjectProvider = applicationContext.getBeanProvider(User2.class);
        printBeansException("displayObjectProviderStreamOps", () -> User2ObjectProvider.forEach(System.out::println));
    }

    private static void displayBeanFactoryUtilsBeansOfTypeIncludingAncestor(AnnotationConfigApplicationContext applicationContext) {
        printBeansException("displayBeanFactoryUtilsBeansOfTypeIncludingAncestor", () -> BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, User2.class));
    }



    private static void printBeansException(String source, Runnable runnable) {
        System.err.println("==========================================");
        System.err.println("Source from :" + source);
        try {

        } catch (BeansException exception) {
            exception.printStackTrace();
        }
    }
}

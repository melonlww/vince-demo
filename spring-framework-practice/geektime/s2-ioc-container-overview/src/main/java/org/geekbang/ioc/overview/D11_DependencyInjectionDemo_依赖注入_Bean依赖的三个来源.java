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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入的beanFactory和依赖查找的beanFactory并非同一个
 */
public class D11_DependencyInjectionDemo_依赖注入_Bean依赖的三个来源 {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context5.xml");

        // 依赖来源一：自定义 Bean
        UserRepository4 userRepository = beanFactory.getBean("userRepository", UserRepository4.class);
//        System.out.println(userRepository.getUsers());
        // 依赖来源二：依赖注入（內建依赖）
        System.out.println(userRepository.getBeanFactory());
        //false
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory objectFactory = userRepository.getObjectFactory();
        //true
        System.out.println(objectFactory.getObject() == beanFactory);

        // 依赖来源三：容器內建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }


}

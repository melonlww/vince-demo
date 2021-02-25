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
package org.geekbang.spring.bean;

import org.geekbang.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 注解 BeanDefinition 示例
 *
 * 在多重注解下是否会重复注册？
 * 否
 */
@Import(D4_AnnotationBeanDefinitionDemo_注解BeanDefinition注册_在多重注解下是否会重复注册.Config.class)
public class D4_AnnotationBeanDefinitionDemo_注解BeanDefinition注册_在多重注解下是否会重复注册 {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(D4_AnnotationBeanDefinitionDemo_注解BeanDefinition注册_在多重注解下是否会重复注册.class);

        applicationContext.refresh();

        System.out.println("Config 类型的所有 Beans：" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans：" + applicationContext.getBeansOfType(User.class));

        System.out.println("别名bean：" + applicationContext.getBean("xiaoabao-user"));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Component
    public static class Config {
        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         */
        @Bean(name = {"user", "xiaoabao-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小啊宝");
            return user;
        }
    }


}

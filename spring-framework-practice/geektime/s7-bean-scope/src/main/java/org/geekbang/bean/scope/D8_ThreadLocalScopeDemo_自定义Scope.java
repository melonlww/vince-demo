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
package org.geekbang.bean.scope;

import org.geekbang.bean.scope.annoation.ThreadLocalScopeAnnotation;
import org.geekbang.ioc.overview.domain.User6;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


/**
 * 自定义 Scope {@link ThreadLocalScope} 示例
 */
public class D8_ThreadLocalScopeDemo_自定义Scope {

    @Bean
    @ThreadLocalScopeAnnotation //模拟@RequestScope实现 替换@Scope(ThreadLocalScope.SCOPE_NAME)
    public User6 user() {
        return createUser();
    }

    private static User6 createUser() {
        User6 user = new User6();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D8_ThreadLocalScopeDemo_自定义Scope.class);

        /**
         * 注册自定义 scope
         */
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
        });

        // 启动 Spring 应用上下文
        applicationContext.refresh();
        /**
         * 同个线程
         */
        scopedBeansByCurrentThreadLookup(applicationContext);
        /**
         * 不同线程
         */
        scopedBeansByMultiThreadLookup(applicationContext);

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static void scopedBeansByCurrentThreadLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            // user 是共享 Bean 对象
            User6 user = applicationContext.getBean("user", User6.class);
            System.out.printf("[Thread id :%d] user = %s%n", Thread.currentThread().getId(), user);
        }
    }

    private static void scopedBeansByMultiThreadLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                User6 user = applicationContext.getBean("user", User6.class);
                System.out.printf("[Thread id :%d] user = %s%n", Thread.currentThread().getId(), user);
            });

            // 启动线程
            thread.start();
            // 强制线程执行完成
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

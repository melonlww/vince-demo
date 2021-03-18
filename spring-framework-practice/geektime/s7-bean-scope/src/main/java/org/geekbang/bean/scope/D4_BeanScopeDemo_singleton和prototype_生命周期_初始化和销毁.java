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

import org.geekbang.ioc.overview.domain.User6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * Bean 的作用域示例
 *
 *  结论一：
 *  Singleton Bean 无论依赖查找还是依赖注入，均为同一个对象
 *  Prototype Bean 无论依赖查找还是依赖注入，均为新生成的对象
 *
 *  结论二：
 *  如果依赖注入集合类型的对象，Singleton Bean 和 Prototype Bean 均会存在一个
 *  Prototype Bean 有别于其他地方的依赖注入 Prototype Bean
 *  (看打印的beanScopeDemo.users)
 *
 *
 * 结论三：
 *  无论是 Singleton 还是 Prototype Bean 均会执行初始化方法回调
 *  不过仅 Singleton Bean 会执行销毁方法回调
 *
 *
 *
 * 输出：
 * =======================================
 * User Bean [singletonUser] 初始化...
 * User Bean [prototypeUser] 初始化...
 * User Bean [prototypeUser] 初始化...
 * User Bean [prototypeUser] 初始化...
 * User Bean [prototypeUser] 初始化...
 * 依赖查找：
 * singletonUser = User5{id=76399353465365, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * User Bean [prototypeUser] 初始化...
 * prototypeUser = User5{id=76399414918917, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * singletonUser = User5{id=76399353465365, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * User Bean [prototypeUser] 初始化...
 * prototypeUser = User5{id=76399417014053, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * singletonUser = User5{id=76399353465365, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * User Bean [prototypeUser] 初始化...
 * prototypeUser = User5{id=76399417467678, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * =======================
 * 依赖注入：
 * beanScopeDemo.singletonUser = User5{id=76399353465365, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * beanScopeDemo.singletonUser1 = User5{id=76399353465365, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * beanScopeDemo.prototypeUser = User5{id=76399362011043, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * beanScopeDemo.prototypeUser1 = User5{id=76399363300340, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * beanScopeDemo.prototypeUser2 = User5{id=76399364215530, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}
 * beanScopeDemo.users = {singletonUser=User5{id=76399353465365, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}, prototypeUser=User5{id=76399370132993, name='null', city=null, workCities=null, lifeCities=null, configFileLocation=null}}
 * User Bean [singletonUser] 销毁中...
 *
 */
public class D4_BeanScopeDemo_singleton和prototype_生命周期_初始化和销毁 {

    /**
     * 默认 scope 就是 "singleton"
     */
    @Bean
    public static User6 singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User6 prototypeUser() {
        return createUser();
    }

    private static User6 createUser() {
        User6 user = new User6();
        user.setId(System.nanoTime());
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User6 singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User6 singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User6 prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User6 prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User6 prototypeUser2;

    @Autowired
    private Map<String, User6> users;

    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(D4_BeanScopeDemo_singleton和prototype_生命周期_初始化和销毁.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        System.out.println("依赖查找：");
        scopedBeansByLookup(applicationContext);

        System.out.println("=======================");
        System.out.println("依赖注入：");
        scopedBeansByInjection(applicationContext);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    private static void scopedBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            /**
             * singletonUser 是共享 Bean 对象
             */
            User6 singletonUser = applicationContext.getBean("singletonUser", User6.class);
            System.out.println("singletonUser = " + singletonUser);
            /**
             * prototypeUser 是每次依赖查找均生成了新的 Bean 对象
             */
            User6 prototypeUser = applicationContext.getBean("prototypeUser", User6.class);
            System.out.println("prototypeUser = " + prototypeUser);
        }
    }

    private static void scopedBeansByInjection(AnnotationConfigApplicationContext applicationContext) {
        D4_BeanScopeDemo_singleton和prototype_生命周期_初始化和销毁 beanScopeDemo = applicationContext.getBean(D4_BeanScopeDemo_singleton和prototype_生命周期_初始化和销毁.class);

        System.out.println("beanScopeDemo.singletonUser = " + beanScopeDemo.singletonUser);
        System.out.println("beanScopeDemo.singletonUser1 = " + beanScopeDemo.singletonUser1);

        System.out.println("beanScopeDemo.prototypeUser = " + beanScopeDemo.prototypeUser);
        System.out.println("beanScopeDemo.prototypeUser1 = " + beanScopeDemo.prototypeUser1);
        System.out.println("beanScopeDemo.prototypeUser2 = " + beanScopeDemo.prototypeUser2);

        System.out.println("beanScopeDemo.users = " + beanScopeDemo.users);
    }

}
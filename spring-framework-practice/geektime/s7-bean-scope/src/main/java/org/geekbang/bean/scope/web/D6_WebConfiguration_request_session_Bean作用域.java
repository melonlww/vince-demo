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
package org.geekbang.bean.scope.web;

import org.geekbang.ioc.overview.domain.User6;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 增加Web MVC 配置类
 *
 * maven打war包:
 *      cd ~/practice/code/vince-demo/spring-framework-practice/geektime
 *      mvn clean package
 *
 * 启动war
 *      cd ~/practice/code/vince-demo/spring-framework-practice/geektime/s7-bean-scope/target
 *      java -jar s7-bean-scope-1.0-SNAPSHOT-war-exec.jar
 *
 * debug调试
 *      java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9527 s7-bean-scope-1.0-SNAPSHOT-war-exec.jar
 *
 * 请求：http://localhost:8080/index.html
 *
 * 实验一：
 * @RequestScope 每次请求都会生成一个新的bean
 * 代码：{@link org.springframework.web.context.request.RequestScope}
 *
 * 打印：
 * ============================
 * User Bean [scopedTarget.user] 初始化...
 * User Bean [scopedTarget.user] 销毁中...
 * User Bean [scopedTarget.user] 初始化...
 * User Bean [scopedTarget.user] 销毁中...
 *
 *
 *
 * 实验二：
 * @SessionScope ，当有新的cookie/session时，会生成新的bean，   用户可能打开浏览器的多个tab，为防止有可能的并发问题SessionScope用了synchronized锁处理
 * 代码：{@link org.springframework.web.context.request.SessionScope}
 *
 * @Override
 * public Object get(String name, ObjectFactory<?> objectFactory) {
 * 		Object mutex = RequestContextHolder.currentRequestAttributes().getSessionMutex();
 * 		synchronized (mutex) {
 * 			return super.get(name, objectFactory);
 *        }
 * }
 *
 *
 * 用chrome和safari各请求一次(不要用curl命令做测试，因为curl没有cookie)
 * 打印：
 * ============================
 * User Bean [scopedTarget.user] 初始化...
 * User Bean [scopedTarget.user] 初始化...
 *
 */
@Configuration
@EnableWebMvc
public class D6_WebConfiguration_request_session_Bean作用域 {

    @Bean
    @RequestScope
//    @SessionScope
    public User6 user6() {
        User6 user = new User6();
        user.setId(System.nanoTime());
        user.setName("小ww");
        return user;
    }

}

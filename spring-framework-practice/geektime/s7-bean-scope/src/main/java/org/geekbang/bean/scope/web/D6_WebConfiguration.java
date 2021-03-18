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
import org.springframework.web.context.annotation.ApplicationScope;
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
 *
 *
 * @RequestScope 每次请求都会生成一个新的bean
 * 打印：
 * ============================
 * User Bean [scopedTarget.user] 初始化...
 * User Bean [scopedTarget.user] 销毁中...
 * User Bean [scopedTarget.user] 初始化...
 * User Bean [scopedTarget.user] 销毁中...
 *
 *
 *
 *
 *
 */
@Configuration
@EnableWebMvc
public class D6_WebConfiguration {

    @Bean
    @RequestScope
//    @SessionScope
//    @ApplicationScope
    public User6 user() {
        User6 user = new User6();
        user.setId(System.nanoTime());
        user.setName("小ww");
        return user;
    }

}

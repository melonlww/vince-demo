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
package org.geekbang.bean.scope.web.controller;

import org.geekbang.ioc.overview.domain.User6;
import org.geekbang.ioc.overview.domain.User7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页 Spring Web MVC Controller
 *
 * JSP EL 变量搜索路径 page -> request -> session -> application(ServletContext)
 * userObject -> 渲染上下文
 * user 对象存在 ServletContext，上下文名称：scopedTarget.user == 新生成 Bean 名称
 */
@Controller
public class IndexController {

    /**
     * CGLIB 代理后对象（不变的）
     */
    @Autowired
    private User6 user6;

    @Autowired
    private User7 user7;

    /**
     * @RequestScope @SessionScope 测试
     */
    @GetMapping("/index.html")
    public String index(Model model) {
        model.addAttribute("userObject", user6);
        return "index";
    }

    /**
     * @ApplicationScope 测试
     */
    @GetMapping("/index_application.html")
    public String indexApplication(Model model) {
        model.addAttribute("userApplication", user7);
        return "index_application";
    }
}

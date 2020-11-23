package com.xima.spring.boot.exploration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * idea开启remote调试模式
 * java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar spring-boot-exploration-1.0-SNAPSHOT.jar
 *
 * ps：Terminal中执行启动springboot的jar包加-agentlib参数时会报错 zsh不兼容的坑-zsh:no matches found
 * 解决办法：
 * 在~/.zshrc中加入: setopt no_nomatch
 * 然后运行: 	source ~/.zshrc
 *
 *
 *
 *
 *
 */
@RestController
@SpringBootApplication
public class SpringBootExplorationApplication {

	@GetMapping("first")
	public String first(){
		return "hello spring boot";
	}


	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootExplorationApplication.class)
//				.web(WebApplicationType.NONE)
				.run(args);
	}

}

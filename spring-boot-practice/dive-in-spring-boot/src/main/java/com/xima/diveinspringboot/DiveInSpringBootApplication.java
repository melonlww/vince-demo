package com.xima.diveinspringboot;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@ServletComponentScan(basePackages = "com.xima.diveinspringboot.web.servlet")
@SpringBootApplication
public class  DiveInSpringBootApplication {

	public static void main(String[] args) {

//		SpringApplication.run(DiveInSpringBootApplication.class, args);

		ConfigurableApplicationContext context = new SpringApplicationBuilder(DiveInSpringBootApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		System.out.println(context);
	}

}

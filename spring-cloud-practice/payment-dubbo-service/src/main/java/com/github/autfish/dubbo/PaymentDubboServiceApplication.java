package com.github.autfish.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentDubboServiceApplication.class, args);
    }

}

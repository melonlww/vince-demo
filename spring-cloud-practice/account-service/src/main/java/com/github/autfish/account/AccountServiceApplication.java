package com.github.autfish.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1. 开启nacos
 * cd ~/practice/code/vince-practice/spring-cloud-practice/nacos/nacos/bin⚡
 * ⇒   sh startup.sh -m standalone &
 *
 *
 * 访问接口  http://localhost:8081/acc/user?id=1   轮询payment-service服务
 *         http://localhost:8082/pay/balance?id=1
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}

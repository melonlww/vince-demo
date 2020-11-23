package com.github.autfish.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * java -jar payment-service-0.0.1-SNAPSHOT.jar --server.port=8082
 * java -jar payment-service-0.0.1-SNAPSHOT.jar --server.port=8083
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

}

package com.xima.design.pattern.行为型.状态模式_State.s4实例_用Spring实现状态机;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        ConfigurableApplicationContext context = SpringApplication.run(Test.class, args);

        IOrderService orderService = (IOrderService) context.getBean("orderService");

        orderService.create();
        orderService.create();

        orderService.pay(1);

        new Thread(() -> {
            orderService.deliver(1);
            orderService.receive(1);
        }, "客户线程").start();

        orderService.pay(2);
        orderService.deliver(2);
        orderService.receive(2);

        System.out.println("全部订单状态：" + orderService.getOrders());
    }
}

package com.xima.design.pattern.结构型.享元模式_Flyweight.s2实例_买火车票;

import java.util.Random;

public class TrainTicket implements ITicket {

    private String from;

    private String to;

    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(from + "->" + to + ":" + bunk + " 价格：" + this.price);
    }
}

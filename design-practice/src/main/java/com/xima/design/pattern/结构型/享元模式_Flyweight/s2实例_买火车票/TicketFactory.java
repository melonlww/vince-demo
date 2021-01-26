package com.xima.design.pattern.结构型.享元模式_Flyweight.s2实例_买火车票;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {
    private static Map<String, ITicket> pool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (pool.containsKey(key)) {
            System.out.println("使用缓存：" + key);
            return pool.get(key);
        }
        System.out.println("首次查询，创建对象：" + key);
        ITicket ticket = new TrainTicket(from, to);
        pool.put(key, ticket);
        return ticket;
    }
}

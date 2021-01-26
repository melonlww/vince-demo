package com.xima.design.pattern.结构型.享元模式_Flyweight.s2实例_买火车票;

public class Test {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("上海南", "南京");
        ticket.showInfo("硬座");
        ticket = TicketFactory.queryTicket("上海南", "南京");
        ticket.showInfo("软座");

        ticket = TicketFactory.queryTicket("上海虹桥", "南京");
        ticket.showInfo("软座");
    }
}

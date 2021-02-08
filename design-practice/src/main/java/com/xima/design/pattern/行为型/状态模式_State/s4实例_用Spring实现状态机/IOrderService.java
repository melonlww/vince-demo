package com.xima.design.pattern.行为型.状态模式_State.s4实例_用Spring实现状态机;

import java.util.Map;

public interface IOrderService {

    Order create();

    Order pay(int id);

    Order deliver(int id);

    Order receive(int id);

    Map<Integer, Order> getOrders();
}

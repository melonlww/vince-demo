package com.xima.design.pattern.创建型.工厂模式_Factory.s2工厂方法;

import com.xima.design.pattern.创建型.工厂模式_Factory.obj.Watch;
import com.xima.design.pattern.创建型.工厂模式_Factory.obj.ElectronicGoods;

public class WatchFactory implements MethodFactory {
    @Override
    public ElectronicGoods getPhone() {
        return new Watch();
    }
}
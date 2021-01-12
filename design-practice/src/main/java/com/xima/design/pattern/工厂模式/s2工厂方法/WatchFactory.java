package com.xima.design.pattern.工厂模式.s2工厂方法;

import com.xima.design.pattern.工厂模式.obj.ElectronicGoods;
import com.xima.design.pattern.工厂模式.obj.Watch;

public class WatchFactory implements MethodFactory {
    @Override
    public ElectronicGoods getPhone() {
        return new Watch();
    }
}
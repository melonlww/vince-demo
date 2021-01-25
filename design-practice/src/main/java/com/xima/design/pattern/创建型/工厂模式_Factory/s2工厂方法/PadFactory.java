package com.xima.design.pattern.创建型.工厂模式_Factory.s2工厂方法;

import com.xima.design.pattern.创建型.工厂模式_Factory.obj.Pad;
import com.xima.design.pattern.创建型.工厂模式_Factory.obj.ElectronicGoods;

//工厂方法的实现
public class PadFactory implements MethodFactory {
    @Override
    public ElectronicGoods getPhone() {
        return new Pad();
    }
}
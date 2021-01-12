package com.xima.design.pattern.工厂模式.s2工厂方法;

import com.xima.design.pattern.工厂模式.obj.Pad;
import com.xima.design.pattern.工厂模式.obj.ElectronicGoods;

//工厂方法的实现
public class PadFactory implements MethodFactory {
    @Override
    public ElectronicGoods getPhone() {
        return new Pad();
    }
}
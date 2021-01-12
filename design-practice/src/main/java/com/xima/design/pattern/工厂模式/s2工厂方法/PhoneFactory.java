package com.xima.design.pattern.工厂模式.s2工厂方法;

import com.xima.design.pattern.工厂模式.obj.Phone;
import com.xima.design.pattern.工厂模式.obj.ElectronicGoods;

public class PhoneFactory implements MethodFactory {
    @Override
    public ElectronicGoods getPhone() {
        return new Phone();
    }
}

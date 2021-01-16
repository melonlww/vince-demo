package com.xima.design.pattern.创建型.工厂模式.s2工厂方法;

import com.xima.design.pattern.创建型.工厂模式.obj.ElectronicGoods;

//工厂方法接口
public interface MethodFactory {
    ElectronicGoods getPhone();
}
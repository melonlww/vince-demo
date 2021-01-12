package com.xima.design.pattern.工厂模式.s1简单工厂;

import com.xima.design.pattern.工厂模式.obj.Pad;
import com.xima.design.pattern.工厂模式.obj.Phone;
import com.xima.design.pattern.工厂模式.obj.ElectronicGoods;
import com.xima.design.pattern.工厂模式.obj.Watch;

public class SimpleFactory {
    public static ElectronicGoods test(String name) {
        if ("XiaoMi".equals(name)) {
            return new Watch();
        } else if ("IPhone".equals(name)) {
            return new Phone();
        } else if ("HuaWei".equals(name)) {
            return new Pad();
        } else {
            System.out.println("未识别的类型");
            return null;
        }
    }
}

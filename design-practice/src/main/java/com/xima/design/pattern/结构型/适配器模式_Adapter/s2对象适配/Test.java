package com.xima.design.pattern.结构型.适配器模式_Adapter.s2对象适配;

import com.xima.design.pattern.结构型.适配器模式_Adapter.目标方法.AC220;

public class Test {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter(new AC220());
        adapter.output5V();
    }
}

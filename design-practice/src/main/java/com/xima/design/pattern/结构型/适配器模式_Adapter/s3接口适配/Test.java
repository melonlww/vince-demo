package com.xima.design.pattern.结构型.适配器模式_Adapter.s3接口适配;


import com.xima.design.pattern.结构型.适配器模式_Adapter.AC220;

public class Test {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter(new AC220());
        adapter.output5V();
        adapter.output12V();
        adapter.output24V();
    }
}

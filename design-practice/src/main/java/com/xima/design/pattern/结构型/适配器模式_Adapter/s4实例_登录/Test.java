package com.xima.design.pattern.结构型.适配器模式_Adapter.s4实例_登录;

public class Test {
    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        System.out.println(adapter.login("tom","123456"));
        System.out.println(adapter.loginForQQ("wafjaijfewiajfieajfiajf"));
        System.out.println(adapter.loginForWeChat("wafjaijfewiajfieajfiajf"));
    }
}

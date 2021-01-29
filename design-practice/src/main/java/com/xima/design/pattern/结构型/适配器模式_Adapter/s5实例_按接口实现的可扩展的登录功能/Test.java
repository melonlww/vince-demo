package com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能;


public class Test {
    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        System.out.println(adapter.login("tom","123456"));
        System.out.println(adapter.loginForQQ("wafjaijfewiajfieajfiajf"));
    }

}

package com.xima.design.pattern.结构型.适配器模式_Adapter.s4实例_登录;

public class PassportService {

    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "注册成功", null);
    }

    public ResultMsg login(String username, String password) {
        return new ResultMsg(200, "登录成功", null);
    }
}

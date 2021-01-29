package com.xima.design.pattern.结构型.适配器模式_Adapter.s4实例_登录;

import com.xima.design.pattern.结构型.适配器模式_Adapter.目标方法.PassportService;
import com.xima.design.pattern.结构型.适配器模式_Adapter.ResultMsg;

public class PassportForThirdAdapter extends PassportService implements IPassportForThird {

    @Override
    public ResultMsg loginForQQ(String openId) {
        return loginForRegister(openId, null);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return loginForRegister(openId, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return loginForRegister(token, null);
    }

    @Override
    public ResultMsg loginForTel(String phone, String code) {
        return null;
    }

    private ResultMsg loginForRegister(String username, String password) {
        if (null == password) {
            password = "THIRD_EMPTY";
        }
        super.register(username, password);
        return super.login(username, password);
    }
}

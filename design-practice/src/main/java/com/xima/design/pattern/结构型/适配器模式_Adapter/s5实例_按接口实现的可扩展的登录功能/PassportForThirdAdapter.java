package com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能;

import com.xima.design.pattern.结构型.适配器模式_Adapter.ResultMsg;
import com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters.ILoginAdapter;
import com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters.LoginForQQAdapter;
import com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters.LoginForTokenAdapter;
import com.xima.design.pattern.结构型.适配器模式_Adapter.s5实例_按接口实现的可扩展的登录功能.adapters.LoginForWeChatAdapter;
import com.xima.design.pattern.结构型.适配器模式_Adapter.目标方法.PassportService;

public class PassportForThirdAdapter extends PassportService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWeChat(String openId) {
        return processLogin(openId, LoginForWeChatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTel(String phone, String code) {
        return null;
    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz) {
        try {
            ILoginAdapter adapter = clazz.getDeclaredConstructor().newInstance();
            if (adapter.support(adapter)) {
                return adapter.login(id, adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package org.geekbang.ioc.spring.bean.factory;

import org.geekbang.ioc.overview.domain.User2;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link User2} Bean 的 {@link FactoryBean} 实现
 *
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User2.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User2.class;
    }
}

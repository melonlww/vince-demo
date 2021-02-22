package org.geekbang.ioc.overview.repository;

import org.geekbang.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;

/**
 * 用户信息仓库
 */
public class UserRepository2 {

    private Collection<User> users; // 自定义 Bean

    private BeanFactory beanFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}

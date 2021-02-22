package org.geekbang.ioc.overview.repository;

import org.geekbang.ioc.overview.domain.User;

import java.util.Collection;

/**
 * 用户信息仓库
 */
public class UserRepository {

    private Collection<User> users; // 自定义 Bean

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}

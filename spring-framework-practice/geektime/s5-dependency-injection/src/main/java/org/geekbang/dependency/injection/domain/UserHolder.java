package org.geekbang.dependency.injection.domain;


import org.geekbang.ioc.overview.domain.User;

/**
 * {@link User} 的 Holder 类
 *
 */
public class UserHolder {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}

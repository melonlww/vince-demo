package org.geekbang.ioc.overview.domain;

public class User2 {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User2 createUser() {
        User2 user = new User2();
        user.setId(5L);
        user.setName("小宝");
        return user;
    }
}

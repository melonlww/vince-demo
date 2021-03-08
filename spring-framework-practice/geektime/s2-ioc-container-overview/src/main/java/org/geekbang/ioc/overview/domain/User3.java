package org.geekbang.ioc.overview.domain;

import org.geekbang.ioc.overview.enums.City;
import org.springframework.core.io.Resource;

public class User3 {

    private Long id;

    private String name;

    private City city;

    private Resource configFileLocation;

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

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User3 createUser() {
        User3 user = new User3();
        user.setId(6L);
        user.setName("小宝");
        return user;
    }
}

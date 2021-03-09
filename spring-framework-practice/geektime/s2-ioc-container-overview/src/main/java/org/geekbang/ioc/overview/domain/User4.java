package org.geekbang.ioc.overview.domain;

import org.geekbang.ioc.overview.enums.City;
import org.springframework.core.io.Resource;

import java.util.Arrays;

public class User4 {

    private Long id;

    private String name;

    private City city;

    private City[] workCities;

    private Resource configFileLocation;

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

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
        return "User4{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User4 createUser() {
        User4 user = new User4();
        user.setId(6L);
        user.setName("小宝");
        return user;
    }
}

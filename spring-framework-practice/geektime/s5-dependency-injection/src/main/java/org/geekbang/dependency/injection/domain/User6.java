package org.geekbang.dependency.injection.domain;

import org.geekbang.dependency.injection.annotation.MyPostConstruct;
import org.geekbang.ioc.overview.enums.City;
import org.springframework.core.io.Resource;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

public class User6 {

    private Long id;

    private String name;

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

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

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
    }

    @MyPostConstruct
    public void init() {
        System.out.println("@MyPostConstruct : UserFactory 初始化中...");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy : UserFactory 销毁中...");
    }

    @Override
    public String toString() {
        return "User6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User6 createUser() {
        User6 user = new User6();
        user.setId(6L);
        user.setName("小宝");
        return user;
    }
}

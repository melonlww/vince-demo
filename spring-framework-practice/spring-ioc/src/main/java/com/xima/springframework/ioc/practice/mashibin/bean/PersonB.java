package com.xima.springframework.ioc.practice.mashibin.bean;

public class PersonB {

    private String name;

    private int age;

    private PersonA personA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonA getPersonA() {
        return personA;
    }

    public void setPersonA(PersonA personA) {
        this.personA = personA;
    }

    @Override
    public String toString() {
        return "PersonB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personA=" + personA +
                '}';
    }
}

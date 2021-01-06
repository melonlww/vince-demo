package com.xima.springframework.ioc.practice.mashibin.bean;

public class PersonA{

    private String name;

    private int age;

    private PersonB personB;

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

    public PersonB getPersonB() {
        return personB;
    }

    public void setPersonB(PersonB personB) {
        this.personB = personB;
    }

    @Override
    public String toString() {
        return "PersonA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personB=" + personB +
                '}';
    }
}

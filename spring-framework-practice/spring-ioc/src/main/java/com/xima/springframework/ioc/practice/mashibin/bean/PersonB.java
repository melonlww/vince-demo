package com.xima.springframework.ioc.practice.mashibin.bean;

public class PersonB {

    private PersonA personA;

    public PersonA getPersonA() {
        return personA;
    }

    public void setPersonA(PersonA personA) {
        this.personA = personA;
    }

    @Override
    public String toString() {
        return "PersonB{" +
                "personA=" + personA +
                '}';
    }
}

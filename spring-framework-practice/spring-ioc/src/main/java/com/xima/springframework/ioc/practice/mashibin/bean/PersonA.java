package com.xima.springframework.ioc.practice.mashibin.bean;

public class PersonA{

    private PersonB personB;

    public PersonB getPersonB() {
        return personB;
    }

    public void setPersonB(PersonB personB) {
        this.personB = personB;
    }

    @Override
    public String toString() {
        return "PersonA{" +
                "personB=" + personB +
                '}';
    }
}

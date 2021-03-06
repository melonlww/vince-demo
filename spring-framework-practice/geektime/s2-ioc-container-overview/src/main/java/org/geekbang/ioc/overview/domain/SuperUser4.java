package org.geekbang.ioc.overview.domain;

import org.geekbang.ioc.overview.annotation.Super;

@Super
public class SuperUser4 extends User5 {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}

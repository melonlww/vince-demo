package org.geekbang.ioc.overview.domain;

import org.geekbang.ioc.overview.annotation.Super;

@Super
public class SuperUser3 extends User4 {
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

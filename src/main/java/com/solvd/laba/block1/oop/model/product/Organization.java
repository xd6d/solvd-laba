package com.solvd.laba.block1.oop.model.product;

import com.solvd.laba.block1.oop.model.users.UserAccount;

public class Organization {
    private String name;
    private UserAccount creator;

    public Organization(String name, UserAccount creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreator(UserAccount user) {
        this.creator = user;
    }

    public UserAccount getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        return "Organization{name='" + name + "'}";
    }
}

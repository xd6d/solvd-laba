package com.solvd.laba.block1.OOP.model.product;

import com.solvd.laba.block1.OOP.model.users.User;

public class Organization {
    private String name;
    private User creator;

    public Organization(String name, User creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreator(User user) {
        this.creator = user;
    }

    public User getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        return "Organization{name='" + name + "'}";
    }
}

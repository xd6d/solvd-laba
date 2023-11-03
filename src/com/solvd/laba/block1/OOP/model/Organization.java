package com.solvd.laba.block1.OOP.model;

public class Organization {
    private String name;
    private final User creator;

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

    public User getCreator() {
        return creator;
    }

}

package com.solvd.laba.block1.task2.model;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String name;
    private final User creator;
    private List<Product> products;

    public Organization(String name, User creator) {
        this.name = name;
        this.creator = creator;
        this.products = new ArrayList<>();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

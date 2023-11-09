package com.solvd.laba.block1.OOP.model.product;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{name='" + name + "'}";
    }
}

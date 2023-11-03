package com.solvd.laba.block1.OOP.model;

public class Bucket {
    private final User user;
    private Product[] products;

    public Bucket(User user, Product[] products) {
        this.user = user;
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }
}

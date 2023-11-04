package com.solvd.laba.block1.OOP.model;

public class Bucket {
    private final User user;
    private Product[] products;
    private int nextProduct = 0;

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

    public void addProduct(Product product) {
        if (nextProduct < products.length)
            products[nextProduct++] = product;
        else
            System.out.println("No space for new product");
    }

    public void clearBucket() {
        products = new Product[100];
        nextProduct = 0;
    }
}

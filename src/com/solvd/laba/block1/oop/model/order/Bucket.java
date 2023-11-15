package com.solvd.laba.block1.oop.model.order;

import com.solvd.laba.block1.oop.model.interfaces.Countable;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.exceptions.BucketOverflowException;
import com.solvd.laba.block1.oop.model.product.Product;
import com.solvd.laba.block1.oop.model.users.UserAccount;

import java.util.Arrays;
import java.util.Objects;

public class Bucket implements Countable {
    private final UserAccount user;
    private Product[] products = new Product[Defaults.BUCKET_CAPACITY];
    private int nextProduct = 0;

    public Bucket(UserAccount user, Product[] products) {
        this.user = user;
        this.products = products;
        nextProduct = products.length;
    }

    public Bucket(UserAccount user) {
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
        nextProduct = products.length;
    }

    public UserAccount getUser() {
        return user;
    }

    public void addProduct(Product product) {
        if (nextProduct < products.length)
            products[nextProduct++] = product;
        else
            throw new BucketOverflowException("Your bucket is full. Please create a new one");
    }

    public final void clearBucket() {
        products = new Product[Defaults.BUCKET_CAPACITY];
        nextProduct = 0;
    }

    @Override
    public String toString() {
        return "Bucket{products=" + Arrays.toString(products) + "}";
    }

    @Override
    public double getTotal() {
        return Arrays.stream(products).filter(Objects::nonNull).mapToDouble(Product::getPrice).sum();
    }
}

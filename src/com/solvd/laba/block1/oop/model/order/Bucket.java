package com.solvd.laba.block1.oop.model.order;

import com.solvd.laba.block1.oop.model.interfaces.Countable;
import com.solvd.laba.block1.oop.model.product.Product;
import com.solvd.laba.block1.oop.model.users.UserAccount;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Bucket implements Countable {
    private final UserAccount user;
    private List<Product> products = new LinkedList<>();

    public Bucket(UserAccount user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Bucket(UserAccount user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public UserAccount getUser() {
        return user;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public final void clearBucket() {
        products.clear();
    }

    @Override
    public String toString() {
        return "Bucket{products=" + products + "}";
    }

    @Override
    public double getTotal() {
        return products.stream().filter(Objects::nonNull).mapToDouble(Product::getPrice).sum();
    }
}

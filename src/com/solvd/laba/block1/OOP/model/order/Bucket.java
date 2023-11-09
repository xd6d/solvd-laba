package com.solvd.laba.block1.OOP.model.order;

import com.solvd.laba.block1.OOP.model.Defaults;
import com.solvd.laba.block1.OOP.model.product.Product;
import com.solvd.laba.block1.OOP.model.users.UserAccount;

import java.util.Arrays;
import java.util.Objects;

public class Bucket implements Countable {
    private final UserAccount user;
    private Product[] products;
    private int nextProduct = 0;

    public Bucket(UserAccount user, Product[] products) {
        this.user = user;
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public UserAccount getUser() {
        return user;
    }

    public void addProduct(Product product) {
        if (nextProduct < products.length)
            products[nextProduct++] = product;
        else
            System.out.println("No space for new product");
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

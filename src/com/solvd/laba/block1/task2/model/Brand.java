package com.solvd.laba.block1.task2.model;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private String name;
    private List<Product> products;

    public Brand(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}

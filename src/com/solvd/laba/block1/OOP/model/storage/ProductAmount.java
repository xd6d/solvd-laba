package com.solvd.laba.block1.OOP.model.storage;

import com.solvd.laba.block1.OOP.model.product.Product;

public class ProductAmount {
    private final Product product;
    private int amount;

    public ProductAmount(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

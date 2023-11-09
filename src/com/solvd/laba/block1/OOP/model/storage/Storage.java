package com.solvd.laba.block1.OOP.model.storage;

import com.solvd.laba.block1.OOP.model.product.Product;

public interface Storage {
    ProductAmount[] getAllProducts();
    void addProducts(Product product, int amount);

    void removeProducts(Product product, int amount);
    int getAmount(Product product);
}

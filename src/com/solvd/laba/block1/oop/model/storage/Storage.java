package com.solvd.laba.block1.oop.model.storage;

import com.solvd.laba.block1.oop.model.exceptions.NoSuchProductException;
import com.solvd.laba.block1.oop.model.product.Product;

public interface Storage {
    ProductAmount[] getAllProducts();
    void addProducts(Product product, int amount);
    void removeProducts(Product product, int amount) throws NoSuchProductException;
    int getAmount(Product product);
}

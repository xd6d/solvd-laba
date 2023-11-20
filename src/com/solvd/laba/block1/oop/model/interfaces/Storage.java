package com.solvd.laba.block1.oop.model.interfaces;

import com.solvd.laba.block1.oop.model.exceptions.NoSuchProductException;
import com.solvd.laba.block1.oop.model.exceptions.ProductAmountException;
import com.solvd.laba.block1.oop.model.product.Product;
import com.solvd.laba.block1.oop.model.storage.ProductAmount;

public interface Storage {
    ProductAmount[] getAllProducts();

    void addProducts(Product product, int amount) throws ProductAmountException;

    void removeProducts(Product product, int amount) throws NoSuchProductException, ProductAmountException;

    int getAmount(Product product);
}

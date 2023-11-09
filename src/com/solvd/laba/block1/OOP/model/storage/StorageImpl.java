package com.solvd.laba.block1.OOP.model.storage;

import com.solvd.laba.block1.OOP.model.product.Product;

public class StorageImpl implements Storage {
    private ProductAmount[] allProducts = new ProductAmount[20];
    private int nextProduct = 0;

    @Override
    public ProductAmount[] getAllProducts() {
        return allProducts;
    }

    @Override
    public void addProducts(Product product, int amount) {
        for (ProductAmount entry : allProducts) {
            if (entry != null && entry.getProduct().equals(product)) {
                entry.setAmount(entry.getAmount() + amount);
                return;
            }
        }
        if (nextProduct < allProducts.length)
            allProducts[nextProduct++] = new ProductAmount(product, amount);
        else {
            ProductAmount[] newContainer = new ProductAmount[nextProduct + nextProduct / 2];
            System.arraycopy(allProducts, 0, newContainer, 0, allProducts.length);
            newContainer[nextProduct++] = new ProductAmount(product, amount);
            allProducts = newContainer;
        }
    }

    @Override
    public void removeProducts(Product product, int amount) {
        for (ProductAmount entry : allProducts)
            if (entry != null && entry.getProduct().equals(product)) {
                entry.setAmount(entry.getAmount() - amount);
            }
    }

    @Override
    public int getAmount(Product product) {
        for (ProductAmount entry : allProducts)
            if (entry != null && entry.getProduct().equals(product)) {
                return entry.getAmount();
            }
        return 0;
    }
}

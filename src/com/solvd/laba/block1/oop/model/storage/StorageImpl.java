package com.solvd.laba.block1.oop.model.storage;

import com.solvd.laba.block1.oop.model.exceptions.NoSuchProductException;
import com.solvd.laba.block1.oop.model.exceptions.ProductAmountException;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.product.Product;

public class StorageImpl implements Storage {
    private ProductAmount[] allProducts = new ProductAmount[20];
    private int nextProduct = 0;

    @Override
    public ProductAmount[] getAllProducts() {
        return allProducts;
    }

    @Override
    public void addProducts(Product product, int amount) throws ProductAmountException {
        checkAmountPositive(amount);
        for (ProductAmount entry : allProducts) {
            if (entry != null && entry.getProduct().equals(product)) {
                entry.setAmount(entry.getAmount() + amount);
                return;
            }
        }
        if (nextProduct >= allProducts.length) {
            ProductAmount[] newContainer = new ProductAmount[nextProduct + nextProduct / 2 + 1];
            System.arraycopy(allProducts, 0, newContainer, 0, allProducts.length);
            allProducts = newContainer;
        }
        allProducts[nextProduct++] = new ProductAmount(product, amount);
    }

    private void checkAmountPositive(int amount) throws ProductAmountException {
        if (amount < 0)
            throw new ProductAmountException("Set positive amount. Amount: %d".formatted(amount));
    }

    @Override
    public void removeProducts(Product product, int amount) throws NoSuchProductException, ProductAmountException {
        checkAmountPositive(amount);
        for (ProductAmount entry : allProducts)
            if (entry != null && entry.getProduct().equals(product)) {
                if (entry.getAmount() >= amount) {
                    entry.setAmount(entry.getAmount() - amount);
                } else
                    throw new ProductAmountException
                            ("There are not enough products at the storage: %d.".formatted(entry.getAmount()));
                return;
            }
        throw new NoSuchProductException("Recording about this product is absent. Product: %s".formatted(product.getName()));
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

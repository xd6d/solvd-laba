package com.solvd.laba.block1.oop.services;

import com.solvd.laba.block1.oop.exceptions.AmountException;
import com.solvd.laba.block1.oop.exceptions.NoSuchItemException;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductStorageService {
    private static final Logger LOGGER = LogManager.getLogger(ProductStorageService.class);

    public void addProducts(Storage<Product> storage, Product product, int amount) {
        try {
            storage.add(product, amount);
        } catch (AmountException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }

    public void removeProducts(Storage<Product> storage, Product product, int amount) {
        try {
            storage.remove(product, amount);
        } catch (NoSuchItemException | AmountException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }
}

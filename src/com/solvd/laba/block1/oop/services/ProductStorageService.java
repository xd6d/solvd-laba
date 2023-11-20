package com.solvd.laba.block1.oop.services;

import com.solvd.laba.block1.oop.model.exceptions.NoSuchProductException;
import com.solvd.laba.block1.oop.model.exceptions.ProductAmountException;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductStorageService {
    private static final Logger LOGGER = LogManager.getLogger(BucketService.class);

    public void addProducts(Storage storage, Product product, int amount) {
        try {
            storage.addProducts(product, amount);
        } catch (ProductAmountException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }

    public void removeProducts(Storage storage, Product product, int amount) {
        try {
            storage.removeProducts(product, amount);
        } catch (NoSuchProductException | ProductAmountException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }
}

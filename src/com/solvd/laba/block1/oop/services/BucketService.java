package com.solvd.laba.block1.oop.services;

import com.solvd.laba.block1.oop.model.exceptions.BucketOverflowException;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.order.Bucket;
import com.solvd.laba.block1.oop.model.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BucketService {

    private static final Logger LOGGER = LogManager.getLogger(BucketService.class);

    public void addProduct(Bucket bucket, Product product) {
        try {
            bucket.addProduct(product);
        } catch (BucketOverflowException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }
}

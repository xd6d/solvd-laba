package com.solvd.laba.block1.oop.service;

import com.solvd.laba.block1.oop.exceptions.AmountException;
import com.solvd.laba.block1.oop.exceptions.NoSuchItemException;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.order.Bucket;
import com.solvd.laba.block1.oop.model.product.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public double getTotalWithThreads(Bucket bucket, int threadsAmount) {
        AtomicReference<Double> sum = new AtomicReference<>();
        sum.set(0.);
        int bucketSize = bucket.getProducts().size();
        List<CalculationThread> threads = new ArrayList<>();
        for (int i = 0; i < threadsAmount-1; i++) {
            CalculationThread thread = new CalculationThread(bucket, i * bucketSize / threadsAmount,
                    (i + 1) * bucketSize / threadsAmount);
            threads.add(thread);
            thread.start();
        }
        CalculationThread thread = new CalculationThread(bucket, (threadsAmount-1) * bucketSize / threadsAmount,
                bucketSize);
        threads.add(thread);
        thread.start();

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
            }
        }

        threads.forEach(t -> sum.set(sum.get() + t.getSum()));
        return sum.get();
    }
}

package com.solvd.laba.block1.oop;

import com.solvd.laba.block1.oop.exceptions.NegativePriceException;
import com.solvd.laba.block1.oop.model.order.Bucket;
import com.solvd.laba.block1.oop.model.product.Product;
import com.solvd.laba.block1.oop.services.ProductStorageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoMultithreading {
    private static final Logger LOGGER = LogManager.getLogger(DemoMultithreading.class);

    public static void main(String[] args) throws NegativePriceException {
        int bucketSize = 5000;
        int numberOfThreads = 4;

        ProductStorageService service = new ProductStorageService();
        Bucket bucket = new Bucket(null);
        Product someProduct = new Product("product", 1, null, null, null, false);
        for (int i = 0; i < bucketSize; i++) {
            bucket.addProduct(someProduct);
        }

        //With single thread
        long before = System.currentTimeMillis();
        double total = bucket.getTotal();
        long after = System.currentTimeMillis();
        LOGGER.info("Executed in a single thread");
        LOGGER.info("Total: " + total);
        LOGGER.info("Time in ms: " + (after - before));

        //With 'class extends Thread'
        before = System.currentTimeMillis();
        total = service.getTotalWithThreadClass(bucket, numberOfThreads);
        after = System.currentTimeMillis();
        LOGGER.info("Executed in " + numberOfThreads + " threads");
        LOGGER.info("Total: " + total);
        LOGGER.info("Time in ms: " + (after - before));

        //With Runnable
        before = System.currentTimeMillis();
        total = service.getTotalWithRunnable(bucket, numberOfThreads);
        after = System.currentTimeMillis();
        LOGGER.info("Executed in " + numberOfThreads + " threads");
        LOGGER.info("Total: " + total);
        LOGGER.info("Time in ms: " + (after - before));
    }
}

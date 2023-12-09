package com.solvd.laba.block1.oop;

import com.solvd.laba.block1.oop.exceptions.NegativePriceException;
import com.solvd.laba.block1.oop.model.order.Bucket;
import com.solvd.laba.block1.oop.model.product.Product;
import com.solvd.laba.block1.oop.model.users.UserAccount;
import com.solvd.laba.block1.oop.service.ProductStorageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DemoMultithreading {
    private static final Logger LOGGER = LogManager.getLogger(DemoMultithreading.class);

    public static void main(String[] args) throws NegativePriceException {
        UserAccount me = new UserAccount("Artem", "Kurkin",
                "email@example.com", "+12345678", "password",
                new GregorianCalendar(2006, Calendar.DECEMBER, 2));

        ProductStorageService service = new ProductStorageService();
        Bucket bucket = new Bucket(me);
        Product someProduct = new Product("product", 1, null, null, null, false);
        for (int i = 0; i < 500; i++) {
            bucket.addProduct(someProduct);
        }

        long before = System.currentTimeMillis();
        double total = bucket.getTotal();
        long after = System.currentTimeMillis();
        LOGGER.info("Executed in a single thread");
        LOGGER.info("Total: " + total);
        LOGGER.info("Time in ms: " + (after - before));

        before = System.currentTimeMillis();
        total = service.getTotalWithThreads(bucket, 4);
        after = System.currentTimeMillis();
        LOGGER.info("Executed in 4 threads");
        LOGGER.info("Total: " + total);
        LOGGER.info("Time in ms: " + (after - before));



        Runnable runnable = () -> {
            for (Product p: bucket.getProducts()) {
                LOGGER.debug(p);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

package com.solvd.laba.block1.OOP;


import com.solvd.laba.block1.OOP.model.enums.PaymentMethod;
import com.solvd.laba.block1.OOP.model.exceptions.NoSuchProductException;
import com.solvd.laba.block1.OOP.model.order.Bucket;
import com.solvd.laba.block1.OOP.model.order.Order;
import com.solvd.laba.block1.OOP.model.product.*;
import com.solvd.laba.block1.OOP.model.storage.Storage;
import com.solvd.laba.block1.OOP.model.storage.StorageImpl;
import com.solvd.laba.block1.OOP.model.users.AbstractAccount;
import com.solvd.laba.block1.OOP.model.users.UserAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Formatter;

public class Demo {
    private static final Logger LOGGER = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        //creating users base
        UserAccount me = new UserAccount("Artem", "Kurkin",
                "email@example.com", "+12345678", "password");
        LOGGER.info("Me: " + me);
        UserAccount seller1 = new UserAccount("John", "White",
                "john@example.com", "+11123456", "qwerty");
        UserAccount seller2 = new UserAccount("Julia", "Black",
                "julia@example.com", "+98765432", "123456_");
        LOGGER.info("Coded password: " + AbstractAccount.codePassword(me.getPassword()));
        LOGGER.warn("Decoded password: " + AbstractAccount.codePassword(AbstractAccount.codePassword(me.getPassword())));

        //creating organizations
        Organization shop1 = new Organization("Best Technics", seller1);
        Organization shop2 = new Organization("Best Shop", seller2);

        //creating categories
        Category tv = new Category("TV");
        Category clothes = new Category("Clothes");

        //creating brands
        Brand samsung = new Brand("Samsung");
        Brand zara = new Brand("Zara");
        Brand levis = new Brand("Levis");

        //create products
        Product samsungTV = new Product("Samsung SmartTV 1", 1000, tv, samsung, shop1);
        Product zaraShirt = new Product("Zara shirt black", 50, clothes, zara, shop2);
        Characteristic sizeM = new Characteristic("Size", "M");
        zaraShirt.addCharacteristic(sizeM);
        Product levisJeans = new Product("Levis jeans classic", 70, clothes, levis, shop2);
        levisJeans.addCharacteristic(sizeM);

        Storage storage = new StorageImpl();
        storage.addProducts(samsungTV, 10);
        storage.addProducts(zaraShirt, 30);
        storage.addProducts(zaraShirt, 10);
        storage.addProducts(levisJeans, 30);
        LOGGER.info("Current Zara shirts amount at storage: " + storage.getAmount(zaraShirt));

        //create order
        Bucket myBucket = new Bucket(me);
        myBucket.addProduct(zaraShirt);
        myBucket.addProduct(zaraShirt);
        myBucket.addProduct(levisJeans);
        Order myOrder = new Order(me, myBucket, me.getContactPhone(), "Kyiv", PaymentMethod.CASH);

        //Get price of order and output it
        double total = myOrder.getTotal();
        LOGGER.info("My order: " + myOrder);
        LOGGER.info("Total by order: " + total);

        //create review
        Review review1 = new Review(zaraShirt, me, 4.4, "Like it, but not perfect");
        Review review2 = new Review(levisJeans, me, 5, "I dress them everytime");
        zaraShirt.addReview(review1);
        levisJeans.addReview(review2);

        try (Formatter formatter = new Formatter()) {
            int removeAmount = 2;
            storage.removeProducts(zaraShirt, removeAmount);
            LOGGER.debug(formatter.format("Successfully removed %d shirts", removeAmount));
        } catch (NoSuchProductException e) {
            LOGGER.warn(e);
        }
    }
}

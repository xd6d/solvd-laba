package com.solvd.laba.block1.oop;


import com.solvd.laba.block1.oop.exceptions.*;
import com.solvd.laba.block1.oop.model.enums.EnterpriseType;
import com.solvd.laba.block1.oop.model.enums.PaymentMethod;
import com.solvd.laba.block1.oop.model.enums.Recommendation;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.order.Bucket;
import com.solvd.laba.block1.oop.model.order.Order;
import com.solvd.laba.block1.oop.model.order.PromoCode;
import com.solvd.laba.block1.oop.model.product.*;
import com.solvd.laba.block1.oop.model.storage.ProductStorage;
import com.solvd.laba.block1.oop.model.users.UserAccount;
import com.solvd.laba.block1.oop.service.ProductStorageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Random;

public class Demo {
    private static final Logger LOGGER = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        //creating users base
        UserAccount me = new UserAccount("Artem", "Kurkin",
                "email@example.com", "+12345678", "password",
                new GregorianCalendar(2006, Calendar.DECEMBER, 2),
                () -> {
                    Random random = new Random();
                    int key1 = random.nextInt();
                    int key2 = random.nextInt();
                    int key3 = random.nextInt();
                    int max = Math.max(key1, key2);
                    return Math.max(max, key3);
                });
        me.setRandomPassword();
        LOGGER.info("Me: " + me);
        UserAccount seller1 = new UserAccount("John", "White",
                "john@example.com", "+11123456", "qwerty",
                new GregorianCalendar(2000, Calendar.DECEMBER, 21));
        UserAccount seller2 = new UserAccount("Julia", "Black",
                "julia@example.com", "+98765432", "123456_",
                new GregorianCalendar(2000, Calendar.MARCH, 11));
        LOGGER.info("Coded password: " + me.codePassword());
        me.setPassword(me.codePassword());
        LOGGER.warn("Decoded password: " + me.codePassword());

        //creating organizations
        Organization shop1 = new Organization("Best Technics", seller1, EnterpriseType.PRIVATE);
        Organization shop2 = new Organization("Best Shop", seller2, EnterpriseType.COLLECTIVE_OWNERSHIP);

        //creating categories
        Category tv = new Category("TV");
        Category clothes = new Category("Clothes");

        //creating brands
        Brand samsung = new Brand("Samsung");
        Brand zara = new Brand("Zara");
        Brand levis = new Brand("Levis");

        //create products
        Product samsungTV = null;
        try {
            samsungTV = new Product("Samsung SmartTV 1", 1000, tv, samsung, shop1, false);
        } catch (NegativePriceException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
        Product zaraShirt = null;
        try {
            zaraShirt = new Product("Zara shirt black", 50, clothes, zara, shop2, false);
            zaraShirt.addCharacteristic("Size", "M");
        } catch (NegativePriceException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
        Product levisJeans = null;
        try {
            levisJeans = new Product("Levis jeans classic", 70, clothes, levis, shop2, false);
            levisJeans.addCharacteristic("Size", "M");
        } catch (NegativePriceException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }


        Storage<Product> storage = new ProductStorage();
        ProductStorageService storageService = new ProductStorageService();
        storageService.addProducts(storage, samsungTV, 10);
        storageService.addProducts(storage, zaraShirt, 30);
        storageService.addProducts(storage, zaraShirt, 10);
        storageService.addProducts(storage, levisJeans, 30);
        StringBuilder productsInStorage = new StringBuilder("\n");
        storage.forEach(p -> productsInStorage.append(p.getProduct().getName()).append("\n"));
        LOGGER.debug("Current products at storage: " + productsInStorage);
        Storage<Product> storage10 = storage.filter(n -> n.getAmount() > 10);
        StringBuilder productsInStorage1 = new StringBuilder("\n");
        storage10.forEach(p -> productsInStorage1.append(p.getProduct().getName()).append("\n"));
        LOGGER.debug("Current products at storage with amount > 10: " + productsInStorage1);
        LOGGER.debug("Its total amount of products: " + storage10.sum(ProductStorage.Node::getAmount));
        LOGGER.debug("Total value of its products: " +
                storage10.mapToDouble(n -> n.getProduct().getPrice() * n.getAmount())
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .sum());
        LOGGER.info("Current Zara shirts amount at storage: " + storage.getAmount(zaraShirt));

        //create order and promo code
        Bucket myBucket = new Bucket(me);
        myBucket.addProduct(zaraShirt);
        myBucket.addProduct(zaraShirt);
        myBucket.addProduct(levisJeans);
        Calendar expiresAt = Calendar.getInstance();
        expiresAt.add(Calendar.DAY_OF_MONTH, 3); //valid for 3 days after creating
        PromoCode promoCode80 = new PromoCode("promo-code", 0.8, expiresAt.getTime());
        try {
            Order myOrder = new Order(me, myBucket, me.getContactPhone(), "Kyiv", PaymentMethod.CASH, promoCode80);
            myOrder.setNextStatus();
            //Get price of order and output it
            double total = myOrder.getTotal();
            LOGGER.info("My order: " + myOrder);
            LOGGER.info("Total by bucket: " + myBucket.getTotal());
            LOGGER.info("Total by order: " + total);
            LOGGER.info("Commission for shop: " + myOrder.getCommission());
        } catch (AccessDeniedException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }

        //create review
        try {
            if (levisJeans != null) {
                levisJeans.addReview(new Review(levisJeans, me, 1.25, "Awful", Recommendation.NOT_RECOMMEND));
            }
        } catch (RatingBoundsException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
        try {
            if (zaraShirt != null) {
                zaraShirt.addReview(new Review(zaraShirt, me, 4.4, "Like it, but not perfect", Recommendation.RECOMMEND));
            }
        } catch (RatingBoundsException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
        try {
            if (levisJeans != null) {
                levisJeans.addReview(new Review(levisJeans, me, 5, "I dress them everytime", Recommendation.RECOMMEND));
            }
        } catch (RatingBoundsException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }

        LOGGER.info("Total rating for " + levisJeans.getName() + ": " + levisJeans.getTotalRating());

        try (Formatter formatter = new Formatter()) {
            int removeAmount = 2;
            storage.remove(zaraShirt, removeAmount);
            LOGGER.debug(formatter.format("Successfully removed %d shirts", removeAmount));
        } catch (NoSuchItemException | AmountException e) {
            LOGGER.warn(Defaults.EXCEPTION_MESSAGE.formatted(e));
        }
    }
}

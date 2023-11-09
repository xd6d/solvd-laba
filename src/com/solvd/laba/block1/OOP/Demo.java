package com.solvd.laba.block1.OOP;


import com.solvd.laba.block1.OOP.model.enums.PaymentMethod;
import com.solvd.laba.block1.OOP.model.order.Bucket;
import com.solvd.laba.block1.OOP.model.order.Order;
import com.solvd.laba.block1.OOP.model.product.*;
import com.solvd.laba.block1.OOP.model.storage.Storage;
import com.solvd.laba.block1.OOP.model.storage.StorageImpl;
import com.solvd.laba.block1.OOP.model.users.Account;
import com.solvd.laba.block1.OOP.model.users.User;

public class Demo {
    public static void main(String[] args) {
        //creating users base
        User me = new User("Artem", "Kurkin",
                "email@example.com", "+12345678", "password");
        System.out.println(me);
        User seller1 = new User("John", "White",
                "john@example.com", "+11123456", "qwerty");
        User seller2 = new User("Julia", "Black",
                "julia@example.com", "+98765432", "123456_");
        System.out.println(Account.codePassword(me.getPassword()));
        System.out.println(Account.codePassword(Account.codePassword(me.getPassword())));

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
        System.out.println(storage.getAmount(zaraShirt));

        //create order
        Bucket myBucket = new Bucket(me, new Product[10]);
        myBucket.addProduct(zaraShirt);
        myBucket.addProduct(zaraShirt);
        myBucket.addProduct(levisJeans);
        Order myOrder = new Order(me, myBucket, me.getContactPhone(), "Kyiv", PaymentMethod.CASH);

        //Get price of order and output it
        double total = myOrder.getTotal();
        System.out.println(myOrder);
        System.out.println(total);

        //create review
        Review review1 = new Review(zaraShirt, me, 4.4, "Like it, but not perfect");
        Review review2 = new Review(levisJeans, me, 5, "I dress them everytime");
        zaraShirt.addReview(review1);
        levisJeans.addReview(review2);
    }
}

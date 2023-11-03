package com.solvd.laba.block1.task2;


import com.solvd.laba.block1.task2.model.*;

public class Demo {
    public static void main(String[] args) {
        //creating users base
        User me = new User("Artem", "Kurkin",
                "email@example.com", "+12345678", "password");
        User seller1 = new User("John", "White",
                "john@example.com", "+11123456", "qwerty");
        User seller2 = new User("Julia", "Black",
                "julia@example.com", "+98765432", "123456_");

        //creating organizations
        Organization shop1 = new Organization("Best Technics", seller1);
        Organization shop2 = new Organization("Best Furniture", seller1);
        Organization shop3 = new Organization("Best Shop", seller2);

        //creating categories
        Category tv = new Category("TV");
        Category clothes = new Category("Clothes");

        //creating brands
        Brand samsung = new Brand("Samsung");
        Brand zara = new Brand("Zara");
        Brand levis = new Brand("Levis");

        //create products
        Product samsungTV = new Product("Samsung SmartTV 1", 1000, tv, samsung, shop1);
        Product zaraShirt = new Product("Zara shirt black", 50, clothes, zara, shop3);
        Product levisJeans = new Product("Levis jeans classic", 70, clothes, levis, shop3);

        //create order
        var myBucket = me.getBucket();
        myBucket.put(zaraShirt, 2);
        myBucket.put(levisJeans, 1);
        Order myOrder = new Order(me, myBucket, me.getContactPhone(), "Kyiv");

        //create review
        Review review1 = new Review(zaraShirt, me, 4.4, "Like it, but not perfect");
        Review review2 = new Review(levisJeans, me, 5, "I dress them everytime");
        zaraShirt.getReviews().add(review1);
        levisJeans.getReviews().add(review2);
    }
}

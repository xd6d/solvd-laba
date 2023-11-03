package com.solvd.laba.block1.task2.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private Category category;
    private Brand brand;
    private final Organization seller;
    private String description;
    private List<CreditOption> creditOptions;
    private List<Review> reviews;
    private List<Characteristic> characteristics;

    public Product(String name, double price, Category category, Brand brand, Organization seller) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.seller = seller;
        this.description = "";
        creditOptions = new ArrayList<>();
        reviews = new ArrayList<>();
        characteristics = new ArrayList<>();
    }

    public Product(String name, double price, Category category, Brand brand, Organization seller, String description) {
        this(name, price, category, brand, seller);
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public Organization getSeller() {
        return seller;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCreditOptions(List<CreditOption> creditOptions) {
        this.creditOptions = creditOptions;
    }

    public List<CreditOption> getCreditOptions() {
        return creditOptions;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }
}

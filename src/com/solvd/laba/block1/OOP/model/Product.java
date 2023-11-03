package com.solvd.laba.block1.OOP.model;

public class Product {
    private static long nextId = 0;
    private final long id = nextId++;
    private String name;
    private double price;
    private Category category;
    private Brand brand;
    private final Organization seller;
    private String description;
    private CreditOption[] creditOptions;
    private Review[] reviews;
    private int nextReview = 0;
    private Characteristic[] characteristics;
    private int nextCharacteristic = 0;

    public Product(String name, double price, Category category, Brand brand, Organization seller) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.seller = seller;
        this.description = "";
        creditOptions = new CreditOption[20];
        reviews = new Review[100];
        characteristics = new Characteristic[100];
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

    public void setCreditOptions(CreditOption[] creditOptions) {
        this.creditOptions = creditOptions;
    }

    public CreditOption[] getCreditOptions() {
        return creditOptions;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        if (nextReview < reviews.length)
            reviews[nextReview++] = review;
        else
            System.out.println("No space for new review");
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setCharacteristics(Characteristic[] characteristics) {
        this.characteristics = characteristics;
    }

    public void addCharacteristic(Characteristic characteristic) {
        if (nextCharacteristic < characteristics.length)
            characteristics[nextCharacteristic++] = characteristic;
        else
            System.out.println("No space for new characteristic");
    }

    public Characteristic[] getCharacteristics() {
        return characteristics;
    }

    public long getId() {
        return id;
    }
}

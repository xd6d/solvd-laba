package com.solvd.laba.block1.OOP.model.product;

import com.solvd.laba.block1.OOP.model.Defaults;
import com.solvd.laba.block1.OOP.model.exceptions.NegativePriceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Product {
    private static final Logger LOGGER = LogManager.getLogger(Product.class);
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
        if (price < 0)
            throw new NegativePriceException("Set positive price. Price: %f.2".formatted(price));
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.seller = seller;
        this.description = "";
        creditOptions = new CreditOption[Defaults.CREDITOPTIONS_CAPACITY];
        reviews = new Review[Defaults.REVIEWS_CAPACITY];
        characteristics = new Characteristic[Defaults.CHARACTERISTICS_CAPACITY];
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
            LOGGER.error("No space for new review in product: %s".formatted(name));
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
            LOGGER.error("No space for new characteristic in product: %s".formatted(name));
    }

    public Characteristic[] getCharacteristics() {
        return characteristics;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price +
                ", category=" + category + ", seller=" + seller + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

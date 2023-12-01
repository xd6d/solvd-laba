package com.solvd.laba.block1.oop.model.product;

import com.solvd.laba.block1.oop.exceptions.NegativePriceException;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;

import java.util.*;

public class Product {
    private static long nextId = 0;
    private final long id = nextId++;
    private final Organization seller;
    private String name;
    private double price;
    private Category category;
    private Brand brand;
    private String description;
    private List<CreditOption> creditOptions;
    private List<Review> reviews;
    private Map<String, String> characteristics;

    public Product(String name, double price, Category category, Brand brand, Organization seller)
            throws NegativePriceException {
        if (price < 0)
            throw new NegativePriceException("Set positive price. Price: %f.2".formatted(price));
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.seller = seller;
        this.description = "";
        creditOptions = new ArrayList<>(Defaults.CREDITOPTIONS_CAPACITY);
        reviews = new LinkedList<>();
        characteristics = new HashMap<>();
    }

    public Product(String name, double price, Category category, Brand brand, Organization seller, String description)
            throws NegativePriceException {
        this(name, price, category, brand, seller);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Organization getSeller() {
        return seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CreditOption> getCreditOptions() {
        return creditOptions;
    }

    public void setCreditOptions(List<CreditOption> creditOptions) {
        this.creditOptions = creditOptions;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addCharacteristic(String name, String value) {
        characteristics.put(name, value);
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
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

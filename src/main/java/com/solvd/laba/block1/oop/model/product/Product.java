package com.solvd.laba.block1.oop.model.product;

import com.solvd.laba.block1.oop.exceptions.NegativePriceException;
import com.solvd.laba.block1.oop.model.enums.Recommendation;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;

import java.util.*;
import java.util.stream.Collectors;

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
    private boolean adult;

    public Product(String name, double price, Category category, Brand brand, Organization seller, boolean adult)
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
        this.adult = adult;
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

    public List<Review> getReviews(int page, int size) {
        return reviews.stream()
                .skip((long) size * (page - 1))
                .limit(size)
                .collect(Collectors.toList());
    }

    public double getTotalRating() {
        return reviews.stream()
                .mapToDouble(r -> {
                    if (r.getRecommendation().equals(Recommendation.NOT_RECOMMEND))
                        return r.getRecommendation().getMultiplier() * (Defaults.MAX_RATE - r.getRate());
                    else
                        return r.getRecommendation().getMultiplier() * r.getRate();
                })
                .sum();
    }

    public List<Review> getPositiveReviews() {
        return reviews.stream()
                .filter(r -> r.getRecommendation() == Recommendation.RECOMMEND)
                .collect(Collectors.toList());
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

    public boolean matchesGivenCharacteristic(String characteristic, String value) {
        return characteristics.entrySet().stream()
                .anyMatch(e -> e.getKey().equals(characteristic) && e.getValue().equals(value));
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

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}

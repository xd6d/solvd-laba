package com.solvd.laba.block1.task2.model;

import java.util.Map;

public class Order {
    private final User user;
    private final Map<Product, Integer> bucket;
    private String contactPhone;
    private String address;
    private Status status;

    public Order(User user, Map<Product, Integer> bucket, String contactPhone, String address) {
        this.user = user;
        this.bucket = bucket;
        this.contactPhone = contactPhone;
        this.address = address;
        this.status = Status.CREATED;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getBucket() {
        return bucket;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

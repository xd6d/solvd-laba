package com.solvd.laba.block1.OOP.model;

import java.util.Arrays;

public class Order {
    private final User user;
    private final Bucket bucket;
    private String contactPhone;
    private String address;
    private Status status;
    private PaymentMethod paymentMethod;

    public Order(User user, Bucket bucket, String contactPhone, String address, PaymentMethod paymentMethod) {
        this.user = user;
        this.bucket = bucket;
        this.contactPhone = contactPhone;
        this.address = address;
        this.status = Status.CREATED;
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return Arrays.stream(bucket.getProducts()).mapToDouble(Product::getPrice).sum();
    }

    public User getUser() {
        return user;
    }

    public Bucket getBucket() {
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

package com.solvd.laba.block1.OOP.model;

import java.util.Arrays;
import java.util.Objects;

public class Order {
    private static long nextId = 0;
    private final long id = nextId++;
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
        return Arrays.stream(bucket.getProducts()).filter(Objects::nonNull).mapToDouble(Product::getPrice).sum();
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", user=" + user + ", bucket=" + bucket + ", total=" + getTotal() +
                ", address='" + address + "', status=" + status + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

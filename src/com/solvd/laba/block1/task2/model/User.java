package com.solvd.laba.block1.task2.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String contactPhone;
    private String password;
    private Map<Product, Integer> bucket;

    public User(String name, String lastName, String email, String contactPhone, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.contactPhone = contactPhone;
        this.password = password;
        this.bucket = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Product, Integer> getBucket() {
        return bucket;
    }

    public void setBucket(Map<Product, Integer> bucket) {
        this.bucket = bucket;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}

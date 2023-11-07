package com.solvd.laba.block1.OOP.model;

public class User extends Account {
    protected Bucket bucket;
    protected boolean blocked;

    public User(String name, String lastName, String email, String contactPhone, String password) {
        super(name, lastName, email, contactPhone, password);
        this.blocked = false;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', lastName='" + lastName + "', email='" + email +
                "', contactPhone='" + contactPhone + "', blocked=" + blocked + "}";
    }

    @Override
    public void greeting() {
        System.out.println("Hi from user " + name + " " + lastName);
    }
}

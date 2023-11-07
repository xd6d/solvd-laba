package com.solvd.laba.block1.OOP.model;

public class Admin extends Account {

    public Admin(String name, String lastName, String email, String contactPhone, String password) {
        super(name, lastName, email, contactPhone, password);
    }

    public void blockUser(User user) {
        user.setBlocked(true);
    }

    public void unblockUser(User user) {
        user.setBlocked(false);
    }

    @Override
    public void greeting() {
        System.out.println("Hello from admin " + name + " " + lastName);
    }
}

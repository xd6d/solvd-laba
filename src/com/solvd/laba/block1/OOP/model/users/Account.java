package com.solvd.laba.block1.OOP.model.users;

import java.util.Objects;
import java.util.Random;

public abstract class Account implements Person {
    protected String name;
    protected String lastName;
    protected String email;
    protected String contactPhone;
    private String password;
    private static final int key;

    static {
        Random random = new Random();
        key = random.nextInt((int) (Math.pow(2, 16) - 1));
    }

    public Account(String name, String lastName, String email, String contactPhone, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.contactPhone = contactPhone;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public abstract void greeting();

    public static String codePassword(String password) {
        StringBuilder res = new StringBuilder();
        for (char c : password.toCharArray())
            res.append((char) (c ^ key));
        return res.toString();
    }

    @Override
    public String toString() {
        return "Account{name='" + name + "', lastName='" + lastName + "', email='" + email +
                "', contactPhone='" + contactPhone + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(email, account.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

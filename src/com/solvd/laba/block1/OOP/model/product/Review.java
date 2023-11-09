package com.solvd.laba.block1.OOP.model.product;

import com.solvd.laba.block1.OOP.model.users.UserAccount;

import java.util.Date;

public class Review {
    private final Product product;
    private final UserAccount creator;
    private final double rate;
    private String text;
    private final Date date;

    public Review(Product product, UserAccount creator, double rate, String text) {
        this.product = product;
        this.creator = creator;
        this.rate = rate;
        this.text = text;
        this.date = new Date();
    }


    public UserAccount getCreator() {
        return creator;
    }

    public double getRate() {
        return rate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }
}

package com.solvd.laba.block1.oop.model.product;

import com.solvd.laba.block1.oop.exceptions.RatingBoundsException;
import com.solvd.laba.block1.oop.model.users.UserAccount;

import java.util.Date;

public class Review {
    private final Product product;
    private final UserAccount creator;
    private final double rate;
    private final Date date;
    private String text;

    public Review(Product product, UserAccount creator, double rate, String text) throws RatingBoundsException {
        if (rate < 1 || rate > 5)
            throw new RatingBoundsException("Set rating between 1 and 5");
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

package com.solvd.laba.block1.oop.model.product;

import com.solvd.laba.block1.oop.exceptions.RatingBoundsException;
import com.solvd.laba.block1.oop.model.enums.Recommendation;
import com.solvd.laba.block1.oop.model.interfaces.Defaults;
import com.solvd.laba.block1.oop.model.users.UserAccount;

import java.util.Date;

public class Review {
    private final Product product;
    private final UserAccount creator;
    private final double rate;
    private final Date date;
    private String text;
    private Recommendation recommendation;

    public Review(Product product, UserAccount creator, double rate, String text, Recommendation recommendation)
            throws RatingBoundsException {
        if (rate < Defaults.MIN_RATE || rate > Defaults.MAX_RATE)
            throw new RatingBoundsException("Set rating between 1 and 5");
        this.product = product;
        this.creator = creator;
        this.rate = rate;
        this.text = text;
        this.recommendation = recommendation;
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

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }
}

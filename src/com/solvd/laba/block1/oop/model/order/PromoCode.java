package com.solvd.laba.block1.oop.model.order;

import java.util.Date;

public class PromoCode {
    private final String code;
    /**
     * Stands between 0 and 1, where 1 is a full price, 0.5 is a half price and 0 is a 100% discount
     */
    private final double priceChange;
    private Date expiresAt;

    public PromoCode(String code, double priceChange, Date expiresAt) {
        this.code = code;
        this.priceChange = priceChange;
        this.expiresAt = expiresAt;
    }

    public String getCode() {
        return code;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isExpired() {
        return expiresAt.compareTo(new Date()) < 0;
    }
}

package com.solvd.laba.block1.oop.model;

import com.solvd.laba.block1.oop.model.enums.CreditCardType;

public class CreditCard {
    private final String number;
    private final CreditCardType type;
    private String owner;

    public CreditCard(String number, String owner, CreditCardType type) {
        this.number = number;
        this.owner = owner;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public CreditCardType getType() {
        return type;
    }
}

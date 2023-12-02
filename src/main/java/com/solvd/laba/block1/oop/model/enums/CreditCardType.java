package com.solvd.laba.block1.oop.model.enums;

public enum CreditCardType {
    MASTERCARD("MasterCard", "5", 16),
    VISA("Visa", "4", 16),
    AMEX("Amex", "34", 15),
    DISCOVER("Discover", "6011", 16);

    final String name;
    final String beginning;
    final int length;

    CreditCardType(String name, String beginning, int length) {
        this.name = name;
        this.beginning = beginning;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getBeginning() {
        return beginning;
    }

    public int getLength() {
        return length;
    }
}

package com.solvd.laba.block1.oop.model.enums;

public enum PaymentMethod {
    CASH(1),
    CARD(1.1),
    CRYPTO(0.9);

    final double coefficient;

    PaymentMethod(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}

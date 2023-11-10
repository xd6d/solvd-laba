package com.solvd.laba.block1.OOP.model.exceptions;

public class NegativePriceException extends RuntimeException {
    public NegativePriceException(String message) {
        super(message);
    }
}

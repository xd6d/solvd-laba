package com.solvd.laba.block1.oop.model.enums;

public enum Status {
    CREATED(0, "Your order has been created"),
    PROCESSING(1, "Looking for products"),
    PACKAGING(2, "Gathering together your order"),
    FORWARDED_TO_DELIVERY(3, "Passed your order to delievery service"),
    DELIVERING(4, "Your order is comming to you"),
    DELIVERED(5, "Your order is waiting for you! You can pick it up"),
    DONE(6, "Done");

    final int index;
    final String message;

    Status(int index, String message) {
        this.index = index;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }
}

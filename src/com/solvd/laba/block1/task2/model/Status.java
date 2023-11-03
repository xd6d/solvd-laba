package com.solvd.laba.block1.task2.model;

public enum Status {
    CREATED(0), PROCESSING(1), PACKAGING(2), FORWARDED_TO_DELIVERY(3), DELIVERING(4), DELIVERED(5), DONE(6);

    private int status;

    Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

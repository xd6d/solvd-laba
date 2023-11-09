package com.solvd.laba.block1.OOP.model.product;

public class CreditOption {
    private String bank;
    private int paymentsAmount;
    private double percent;
    private String description;

    public CreditOption(String bank, int paymentsAmount, double percent, String description) {
        this.bank = bank;
        this.paymentsAmount = paymentsAmount;
        this.percent = percent;
        this.description = description;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getPaymentsAmount() {
        return paymentsAmount;
    }

    public void setPaymentsAmount(int paymentsAmount) {
        this.paymentsAmount = paymentsAmount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.solvd.laba.block1.oop.services;

import com.solvd.laba.block1.oop.model.order.Bucket;
import com.solvd.laba.block1.oop.model.product.Product;

import java.util.List;

public class CalculationThread extends Thread {
    private final Bucket bucket;
    private final int begin;
    private final int end;
    private double sum = 0;

    public CalculationThread(Bucket bucket, int begin, int end) {
        this.bucket = bucket;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        List<Product> products = bucket.getProducts();
        for (int i = begin; i < end; i++) {
            sum += products.get(i).getPrice();
        }
    }

    public double getSum() {
        return sum;
    }
}

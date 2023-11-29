package com.solvd.laba.block1.oop.model.interfaces;

import com.solvd.laba.block1.oop.exceptions.AmountException;
import com.solvd.laba.block1.oop.exceptions.NoSuchItemException;

public interface Storage<T> {
    void add(T item, int amount) throws AmountException;

    void remove(T item, int amount) throws NoSuchItemException, AmountException;

    int getAmount(T item);
}

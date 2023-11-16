package com.solvd.laba.block1.oop.model.interfaces;

import com.solvd.laba.block1.oop.model.exceptions.NoSuchItemException;

public interface Storage<T> {
    void add(T item, int amount);

    void remove(T item, int amount) throws NoSuchItemException;

    int getAmount(T item);
}

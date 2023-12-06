package com.solvd.laba.block1.oop.model.interfaces;

import com.solvd.laba.block1.oop.exceptions.AmountException;
import com.solvd.laba.block1.oop.exceptions.NoSuchItemException;
import com.solvd.laba.block1.oop.model.storage.ProductStorage;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public interface Storage<T> {
    void add(T item, int amount) throws AmountException;

    void remove(T item, int amount) throws NoSuchItemException, AmountException;

    int getAmount(T item);

    void forEach(Consumer<ProductStorage.Node> iterator);

    ProductStorage filter(Predicate<ProductStorage.Node> filter);

    long sum(ToIntFunction<ProductStorage.Node> toIntFunction);

    List<Double> mapToDouble(ToDoubleFunction<ProductStorage.Node> toDoubleFunction);
}

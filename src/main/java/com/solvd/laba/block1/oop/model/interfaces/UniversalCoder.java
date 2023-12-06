package com.solvd.laba.block1.oop.model.interfaces;

@FunctionalInterface
public interface UniversalCoder<T, K, R> {
    R code(T in, K key);
}

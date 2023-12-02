package com.solvd.laba.block1.oop.model.interfaces;

@FunctionalInterface
public interface Coder<T, K> {
    T code(T in, K key);
}

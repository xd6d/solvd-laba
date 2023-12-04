package com.solvd.laba.block1.oop.model.interfaces;

@FunctionalInterface
public interface UnaryCoder<T, K> extends UniversalCoder<T, K, T>{
    T code(T in, K key);
}

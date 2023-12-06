package com.solvd.laba.block1.oop.model.interfaces;

@FunctionalInterface
public interface NumberGenerator<R extends Number> {
    R generate();
}

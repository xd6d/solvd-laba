package com.solvd.laba.block1.oop.model.enums;

public enum Recommendation {
    RECOMMEND(1),
    NEUTRAL(0),
    NOT_RECOMMEND(-1);

    final int multiplier;

    Recommendation(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}

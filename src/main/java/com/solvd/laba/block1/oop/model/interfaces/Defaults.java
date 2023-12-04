package com.solvd.laba.block1.oop.model.interfaces;

import java.util.Random;
import java.util.function.Supplier;

public interface Defaults {
    int CREDITOPTIONS_CAPACITY = 5;

    int MAX_RATE = 5;

    int MIN_RATE = 0;

    String EXCEPTION_MESSAGE = "Resolved %s";

    UnaryCoder<String, Integer> STRING_UNARY_CODER = (in, key) -> {
        StringBuilder res = new StringBuilder();
        for (char c : in.toCharArray())
            res.append((char) (c ^ key));
        return res.toString();
    };

    Supplier<String> RELIABLE_PASSWORD_GENERATOR = () -> {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            password.append((char) (random.nextInt(93) + 33));
        }
        return password.toString();
    };

    UniversalCoder<String, Integer, Integer> STRING_TO_INT_CODER = (in, key) -> in.hashCode() ^ key;

    String SECRET_ENCRYPTION_KEY = ")S0ME-SUP3R_S1CR1T_ENCRYPTION_KEY==";
}

package com.solvd.laba.block1.oop.model.interfaces;

public interface Defaults {
    int CREDITOPTIONS_CAPACITY = 5;

    int MAX_RATE = 5;

    int MIN_RATE = 0;

    String EXCEPTION_MESSAGE = "Resolved %s";

    Coder<String, Integer> STRING_CODER = (in, key) -> {
        StringBuilder res = new StringBuilder();
        for (char c : in.toCharArray())
            res.append((char) (c ^ key));
        return res.toString();
    };
}

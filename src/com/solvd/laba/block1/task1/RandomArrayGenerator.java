package com.solvd.laba.block1.task1;

import java.util.Random;

public class RandomArrayGenerator {
    public int[] getIntArray(int length, int bound) {
        int[] res = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            res[i] = random.nextInt(bound);
        }
        return res;
    }

    /**
     * Generation with default bound set to 100
     */
    public int[] getIntArray(int length) {
        return getIntArray(length, 100);
    }
}

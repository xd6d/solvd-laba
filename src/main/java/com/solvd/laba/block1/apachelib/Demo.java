package com.solvd.laba.block1.apachelib;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        WordService wordService = new WordService();
        wordService.writeToFileSortedByNumber(
                wordService.getUnique(new File("input.txt")), new File("output.txt")
        );
    }
}

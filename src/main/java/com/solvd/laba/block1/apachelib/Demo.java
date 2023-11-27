package com.solvd.laba.block1.apachelib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Demo {
    private static final Logger LOGGER = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        WordService wordService = new WordService();
        LOGGER.info("Number of unique words: " + wordService.getUnique(new File("input.txt")));
    }
}

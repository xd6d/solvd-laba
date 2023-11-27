package com.solvd.laba.block1.apachelib;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WordService {
    private static final Logger LOGGER = LogManager.getLogger(WordService.class);

    private static final String EXCEPTION_MESSAGE = "Resolved %s";

    public int getUnique(File file) {
        try {
            String text = FileUtils.readFileToString(file, Charset.defaultCharset());
            return Arrays.stream(StringUtils.split(text, " \t\n\r[]().,/|\\`\"!@#№;:$%^?")).collect(Collectors.toSet()).size();
        } catch (IOException e) {
            LOGGER.warn(EXCEPTION_MESSAGE.formatted(e));
        }
        return 0;
    }

    public void writeToFile(String text, File file) {
        try {
            FileUtils.write(file, text, Charset.defaultCharset());
        } catch (IOException e) {
            LOGGER.warn(EXCEPTION_MESSAGE.formatted(e));
        }
    }
}

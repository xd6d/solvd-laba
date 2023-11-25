package com.solvd.laba.block1.apachelib;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordService {
    private static final Logger LOGGER = LogManager.getLogger(WordService.class);

    private static final String EXCEPTION_MESSAGE = "Resolved %s";

    public Map<String, Integer> getUnique(File file) {
        Map<String, Integer> words = new HashMap<>();
        try {
            String text = FileUtils.readFileToString(file, Charset.defaultCharset());
            for (String word : StringUtils.split(text, " \t\n\r[]().,/|\\`\"!@#№;:$%^?")) {
                word = StringUtils.toRootLowerCase(word);
                if (words.containsKey(word)) {
                    words.put(word, words.get(word) + 1);
                } else {
                    words.put(word, 1);
                }
            }
        } catch (IOException e) {
            LOGGER.warn(EXCEPTION_MESSAGE.formatted(e));
        }
        return words;
    }

    public void writeToFileSortedByNumber(Map<String, Integer> words, File file) {
        List<String> lines = words.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(e -> e.getKey() + ": " + e.getValue())
                .toList();
        try {
            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            LOGGER.warn(EXCEPTION_MESSAGE.formatted(e));
        }
    }
}

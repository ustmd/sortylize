package com.koral.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class SortBenchmark {

    private static final Logger log = LogManager.getLogger(SortBenchmark.class);

    public static Long measure(Consumer<int[]> method, int[] array) {
        int[] copy = array.clone();

        long start = System.nanoTime();
        method.accept(copy);
        long end = System.nanoTime();
        log.info("Is sort order correct: {}", SortChecker.isCorrectSortOrder(copy));

        return end - start;
    }
}

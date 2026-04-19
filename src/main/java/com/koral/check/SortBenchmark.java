package com.koral.check;

import java.util.function.Consumer;

public class SortBenchmark {

    public static Long measure(Consumer<int[]> method, int[] array) {
        int[] copy = array.clone();

        long start = System.nanoTime();
        method.accept(copy);
        boolean isCorrect = SortChecker.isCorrectSortOrder(copy);
        System.out.println(isCorrect);
        long end = System.nanoTime();

        return end - start;
    }
}

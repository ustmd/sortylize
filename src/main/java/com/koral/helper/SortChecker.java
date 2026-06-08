package com.koral.helper;

public class SortChecker {
    public static boolean isCorrectSortOrder(int[] array) {
        boolean isCorrect = true;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i-1] > array[i]) {
                isCorrect = false;
            }
        }

        return isCorrect;
    }
}

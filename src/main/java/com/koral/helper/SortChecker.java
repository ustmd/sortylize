package com.koral.helper;

public class SortChecker {
    public static boolean isCorrectSortOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
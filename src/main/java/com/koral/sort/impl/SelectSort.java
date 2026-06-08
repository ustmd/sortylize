package com.koral.sort.impl;

public class SelectSort {
    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            // ищем минимальный элемент
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // меняем местами
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }
}

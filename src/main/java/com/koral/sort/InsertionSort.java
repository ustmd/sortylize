package com.koral.sort;

public class InsertionSort {

    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // ищем позицию для вставки через бинарный поиск
            int left = 0;
            int right = i - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[mid] > key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // сдвигаем элементы вправо
            int j = i - 1;
            while (j >= left) {
                array[j + 1] = array[j];
                j--;
            }

            // вставляем элемент
            array[left] = key;
        }

        return array;
    }
}
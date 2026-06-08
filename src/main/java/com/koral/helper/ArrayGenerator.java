package com.koral.helper;

public class ArrayGenerator {
    public int[] generate(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }
}

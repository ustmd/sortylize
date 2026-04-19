package com.koral.gen;

public class ArrayGenerator {
    public int[] generate(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}

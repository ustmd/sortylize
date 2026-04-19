package com.koral;

import com.koral.gen.ArrayGenerator;
import com.koral.sort.BubbleSort;
import com.koral.sort.ShakerSort;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(100); //{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        ShakerSort bubbleSort = new ShakerSort();
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
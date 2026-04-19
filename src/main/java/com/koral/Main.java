package com.koral;

import com.koral.check.SortBenchmark;
import com.koral.gen.ArrayGenerator;
import com.koral.sort.*;


public class Main {
    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(10000); //{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(SortBenchmark.measure(ShakerSort::sort, array));
        System.out.println(SortBenchmark.measure(BinarySort::sort, array));
        System.out.println(SortBenchmark.measure(TreeSort::sort, array));
        System.out.println(SortBenchmark.measure(BubbleSort::sort, array));
        System.out.println(SortBenchmark.measure(SelectSort::sort, array));
    }
}
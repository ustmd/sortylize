package com.koral;

import com.koral.check.SortBenchmark;
import com.koral.gen.ArrayGenerator;
import com.koral.sort.*;

import java.util.function.Consumer;


public class Main {

    private final static Integer ARRAY_SIZE = 100_000;
    private final static Integer SORT_ITERATIONS = 10;
    private final static Integer ARRAY_MAX_VALUE_RANGE = 100_000;

    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(ARRAY_SIZE, ARRAY_MAX_VALUE_RANGE);

        measureSortMethod(BubbleSort.class.getSimpleName(), BubbleSort::sort , array);
        measureSortMethod(InsertionSort.class.getSimpleName(), InsertionSort::sort , array);
        measureSortMethod(ShakerSort.class.getSimpleName(), ShakerSort::sort , array);
        measureSortMethod(SelectSort.class.getSimpleName(), SelectSort::sort , array);
        measureSortMethod(TreeSort.class.getSimpleName(), TreeSort::sort , array);
    }


    private static void measureSortMethod(String name, Consumer<int[]> sortMethod,  int[] array) {
        System.out.println("Sorting");
        System.out.println("Method name: " + name);

        Long totalTime = 0L;

        for (int i = 0; i < Main.SORT_ITERATIONS; i++) {
            Long time = SortBenchmark.measure(sortMethod, array);
            System.out.println(TimeHelper.convertNanoToSeconds(time));
            totalTime += time;
        }

        System.out.println("Avg time: " + TimeHelper.convertNanoToSeconds(totalTime / SORT_ITERATIONS));
    }

}
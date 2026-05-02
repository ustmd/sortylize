package com.koral;

import com.koral.check.SortBenchmark;
import com.koral.gen.ArrayGenerator;
import com.koral.sort.*;

import java.util.function.Consumer;


public class Main {

    private final static Integer ARRAY_SIZE = 100_000;
    private final static Integer SORT_ITERATIONS = 10;

    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(ARRAY_SIZE);

        //measureSortMethod(BubbleSort.class.getSimpleName(), BubbleSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(InsertionSort.class.getSimpleName(), InsertionSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(ShakerSort.class.getSimpleName(), ShakerSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(SelectSort.class.getSimpleName(), SelectSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(TreeSort.class.getSimpleName(), TreeSort::sort , array, SORT_ITERATIONS);
    }


    private static void measureSortMethod(String name, Consumer<int[]> sortMethod,  int[] array, int iterations) {
        System.out.println("Sorting");
        System.out.println("Method name: " + name);

        Long totalTime = 0L;

        for (int i = 0; i < SORT_ITERATIONS; i++) {
            Long time = SortBenchmark.measure(sortMethod, array);
            System.out.println(TimeHelper.convertNanoToSeconds(time));
            totalTime += time;
        }

        System.out.println("Avg time: " + TimeHelper.convertNanoToSeconds(totalTime / SORT_ITERATIONS));
    }

}
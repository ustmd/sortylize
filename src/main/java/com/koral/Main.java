package com.koral;

import com.koral.check.SortBenchmark;
import com.koral.gen.ArrayGenerator;
import com.koral.sort.*;

import java.sql.Time;


public class Main {

    private final static Integer ARRAY_SIZE = 500_000;
    private final static Integer SORT_ITERATIONS = 10;

    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(ARRAY_SIZE);

        Long totalTime = 0L;

        for (int i = 0; i < SORT_ITERATIONS; i++) {
            Long time = SortBenchmark.measure(BubbleSort::sort, array); //SortBenchmark.measure(BinarySort::sort, array);
            System.out.println(TimeHelper.convertNanoToSeconds(time));
            totalTime += time;
        }

        System.out.println("Avg time: " + TimeHelper.convertNanoToSeconds(totalTime / SORT_ITERATIONS));

//        System.out.println(SortBenchmark.measure(ShakerSort::sort, array));
//        System.out.println(SortBenchmark.measure(TreeSort::sort, array));
//        System.out.println(SortBenchmark.measure(BubbleSort::sort, array));
//        System.out.println(SortBenchmark.measure(SelectSort::sort, array));
    }
}
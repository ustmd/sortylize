package com.koral;

import com.koral.util.SortBenchmark;
import com.koral.util.ArrayGenerator;
import com.koral.util.TimeHelper;
import com.koral.sort.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class Main {

    private final static Integer ARRAY_SIZE = 50_000;
    private final static Integer SORT_ITERATIONS = 1;
    private final static Integer ARRAY_MAX_VALUE_RANGE = 100_000;

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(ARRAY_SIZE, ARRAY_MAX_VALUE_RANGE);

        measureSortMethod(BubbleSort.class.getSimpleName(), BubbleSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(InsertionSort.class.getSimpleName(), InsertionSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(ShakerSort.class.getSimpleName(), ShakerSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(SelectSort.class.getSimpleName(), SelectSort::sort , array, SORT_ITERATIONS);
        measureSortMethod(TreeSort.class.getSimpleName(), TreeSort::sort , array, SORT_ITERATIONS);
    }

    private static void measureSortMethod(String name, Consumer<int[]> sortMethod,  int[] array, int iterations) {
        log.info("Sorting");
        log.info("Method name: {}", name);

        Long totalTime = 0L;

        for (int i = 0; i < iterations; i++) {
            Long time = SortBenchmark.measure(sortMethod, array);
            log.info("Iteration {}: {}", i, TimeHelper.convertNanoToSeconds(time));
            totalTime += time;
        }

        log.info("Avg time: {}", TimeHelper.convertNanoToSeconds(totalTime / iterations));
    }
}
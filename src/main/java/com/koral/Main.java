package com.koral;

import com.koral.helper.SortBenchmark;
import com.koral.helper.ArrayGenerator;
import com.koral.helper.TimeHelper;
import com.koral.sort.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class Main {

    private final static Integer ARRAY_SIZE = 100_000;
    private final static Integer SORT_ITERATIONS = 10;

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[] array = arrayGenerator.generate(ARRAY_SIZE);

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

        for (int i = 0; i < SORT_ITERATIONS; i++) {
            Long time = SortBenchmark.measure(sortMethod, array);
            log.info("Iteration {}: {}", i, TimeHelper.convertNanoToSeconds(time));
            totalTime += time;
        }

        log.info("Avg time: {}", TimeHelper.convertNanoToSeconds(totalTime / SORT_ITERATIONS));
    }
}
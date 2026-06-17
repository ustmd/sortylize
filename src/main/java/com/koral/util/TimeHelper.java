package com.koral.util;

public class TimeHelper {
    public static double convertNanoToSeconds(long nano) {
        return nano / 1_000_000_000.0;
    }
}

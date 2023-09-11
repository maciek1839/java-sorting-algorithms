package com.showmeyourcode.projects.algorithms.benchmark;

import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    public static long getCurrentUsedMemoryInBytes() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static double convertBytesToMegaBytes(long bytes){
        return Math.round(bytes/1e+6);
    }

    public static long convertNsToMs(long nanos){
        return TimeUnit.MILLISECONDS.convert(nanos, TimeUnit.NANOSECONDS);
    }
}

package com.showmeyourcode.projects.algorithms.test_util;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;

public class StaticValueProvider {

    private final static int DATA_MAX_RANGE = 10000;
    private final static int DATA_SIZE = 10000;

    public static int dataMaxRange() {
        return DATA_MAX_RANGE;
    }

    public static int dataSize() {
        return DATA_SIZE;
    }

    public static SortingAppConfiguration getConfig() {
        return new SortingAppConfiguration(dataSize(), DATA_MAX_RANGE);
    }

    public static AlgorithmDataGenerator getDataGenerator() {
        return new AlgorithmDataGenerator(getConfig());
    }

    public static BenchmarkDataGenerator getBenchmarkDataGenerator() {
        return new BenchmarkDataGenerator(getConfig());
    }
}

package com.showmeyourcode.projects.algorithms.test_util;

import com.showmeyourcode.projects.algorithms.generator.DataGenerator;
import com.showmeyourcode.projects.algorithms.model.SortingAppConfiguration;

public class StaticValueProvider {

    private final static int DATA_MAX_RANGE = 10000;
    private final static int DATA_SIZE = 1000;

    public static int dataMaxRange() {
        return DATA_MAX_RANGE;
    }

    public static int dataSize() {
        return DATA_SIZE;
    }

    public static SortingAppConfiguration getConfig() {
        return new SortingAppConfiguration(dataSize(), DATA_MAX_RANGE);
    }

    public static DataGenerator getDataGenerator() {
        return new DataGenerator(getConfig());
    }
}

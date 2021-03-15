package com.showmeyourcode.projects.algorithms.generator;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;

import java.util.Random;

public abstract class BaseDataGenerator {
    protected final Random randomGenerator = new Random();
    private SortingAppConfiguration appConfiguration;

    protected BaseDataGenerator(SortingAppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public int[] generateIntData() {
        var dataSize = appConfiguration.getDataSize();
        var maxRange = appConfiguration.getMaxRange();
        return this.generateIntData(dataSize, maxRange);
    }

    public int[] generateIntData(int dataSize, int maxRange) {
        var result = new int[dataSize];
        for (int i = 0; i < dataSize; i++) {
            result[i] = randomGenerator.nextInt(maxRange);
        }
        return result;
    }
}

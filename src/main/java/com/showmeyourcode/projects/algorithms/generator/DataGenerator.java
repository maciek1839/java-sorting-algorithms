package com.showmeyourcode.projects.algorithms.generator;

import com.showmeyourcode.projects.algorithms.model.SortingAppConfiguration;

import java.util.Random;

public class DataGenerator {
    protected final Random randomGenerator = new Random();
    private SortingAppConfiguration appConfiguration;

    public DataGenerator(SortingAppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public int[] generateIntData() {
        var dataSize = appConfiguration.getDataSize();
        var maxRange = appConfiguration.getMaxRange();
        var result = new int[dataSize];
        for (int i = 0; i < dataSize; i++) {
            result[i] = randomGenerator.nextInt(maxRange);
        }
        return result;
    }

}

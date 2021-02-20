package com.showmeyourcode.projects.algorithms.algorithm;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class AlgorithmBase implements Algorithm {

    protected final int[] randomData;
    protected final Random randomGenerator = new Random();

    protected AlgorithmBase() {
        randomData = new int[Algorithm.DATASET_SIZE];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlgorithmBase that = (AlgorithmBase) o;
        return Objects.equals(randomGenerator, that.randomGenerator) && Arrays.equals(randomData, that.randomData) && o.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public long showUsage() {
        generateData();
        long timeStarted = 0, timeFinished = 0;
        timeStarted = System.currentTimeMillis();
        sortData(randomData);
        timeFinished = System.currentTimeMillis();
        return TimeUnit.SECONDS.convert(timeFinished - timeStarted, TimeUnit.MILLISECONDS);
    }

    protected void generateData() {
        for (int i = 0; i < DATASET_SIZE; i++) {
            randomData[i] = randomGenerator.nextInt() % DATASET_MAX_RANGE;
        }
    }
}

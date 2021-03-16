package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;

import java.util.concurrent.TimeUnit;

public abstract class AlgorithmBase implements Algorithm {

    protected final AlgorithmDataGenerator dataGenerator;

    protected AlgorithmBase(AlgorithmDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @Override
    public long showUsage() {
        var randomData = dataGenerator.generateIntData();
        long timeStarted = 0, timeFinished = 0;
        timeStarted = System.currentTimeMillis();
        sortData(randomData);
        timeFinished = System.currentTimeMillis();
        return TimeUnit.SECONDS.convert(timeFinished - timeStarted, TimeUnit.MILLISECONDS);
    }

    protected boolean isArrayEmpty(int[] array) {
        return array == null || array.length == 0;
    }
}

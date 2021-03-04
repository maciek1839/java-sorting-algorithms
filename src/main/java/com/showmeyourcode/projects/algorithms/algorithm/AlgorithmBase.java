package com.showmeyourcode.projects.algorithms.algorithm;

import com.showmeyourcode.projects.algorithms.generator.DataGenerator;

import java.util.concurrent.TimeUnit;

public abstract class AlgorithmBase implements Algorithm {

    protected final DataGenerator dataGenerator;

    protected AlgorithmBase(DataGenerator dataGenerator) {
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
}

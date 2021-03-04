package com.showmeyourcode.projects.algorithms.algorithm;

public interface Algorithm {

    String getAlgorithmPerformance();

    long showUsage();

    int[] sortData(int[] data);

    AlgorithmType getType();
}

package com.showmeyourcode.projects.algorithms.algorithm;

public interface Algorithm {

    long showUsage();

    int[] sortData(int[] data);

    AlgorithmType getType();
}

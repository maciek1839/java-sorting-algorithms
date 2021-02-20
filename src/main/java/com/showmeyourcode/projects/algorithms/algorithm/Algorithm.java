package com.showmeyourcode.projects.algorithms.algorithm;

public interface Algorithm {
    //we need to fix data's range, for example -100000000 to 100000000
    int DATASET_MAX_RANGE = 100000001;
    int DATASET_SIZE = 100000;

    String getAlgorithmPerformance();

    long showUsage();

    int[] sortData(int[] data);
}

package com.showmeyourcode.projects.algorithms.algorithm;

public interface Algorithm {

    long showUsage();

    int[] sortData(int[] data);

    AlgorithmType getType();

    AlgorithmMetadata getMetadata();

    record AlgorithmMetadata(String nameInMarkdownFormat,
                             String theBestComplexity,
                             String averageComplexity,
                             String worstComplexity,
                             String theWorstSpaceComplexity,
                             String stable,
                             String inPlace) {
    }
}

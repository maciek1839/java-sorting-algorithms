package com.showmeyourcode.projects.algorithms.algorithm;

public interface Algorithm {

    String YES = "yes";
    String NO = "no";

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

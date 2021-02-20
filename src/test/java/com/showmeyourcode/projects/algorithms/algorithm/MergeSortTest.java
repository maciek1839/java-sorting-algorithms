package com.showmeyourcode.projects.algorithms.algorithm;

import org.junit.jupiter.api.BeforeEach;

public class MergeSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new MergeSort();
    }
}

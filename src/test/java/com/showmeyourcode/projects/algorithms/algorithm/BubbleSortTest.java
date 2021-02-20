package com.showmeyourcode.projects.algorithms.algorithm;


import org.junit.jupiter.api.BeforeEach;

class BubbleSortTest extends AlgorithmTestClassBase {

    private BubbleSort bubbleSort;

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new BubbleSort();
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;


import org.junit.jupiter.api.BeforeEach;

class BubbleSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new BubbleSort(algorithmDataGenerator);
    }
}

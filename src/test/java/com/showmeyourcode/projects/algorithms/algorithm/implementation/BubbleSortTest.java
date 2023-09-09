package com.showmeyourcode.projects.algorithms.algorithm.implementation;


import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.BeforeEach;

class BubbleSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new BubbleSort(DefaultComponentsProvider.getDataGenerator());
    }
}

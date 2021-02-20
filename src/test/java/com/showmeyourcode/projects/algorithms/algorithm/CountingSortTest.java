package com.showmeyourcode.projects.algorithms.algorithm;

import org.junit.jupiter.api.BeforeEach;

class CountingSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new CountingSort();
    }
}

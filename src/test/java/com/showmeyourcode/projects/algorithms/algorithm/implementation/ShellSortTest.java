package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import org.junit.jupiter.api.BeforeEach;


class ShellSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new ShellSort(algorithmDataGenerator);
    }
}

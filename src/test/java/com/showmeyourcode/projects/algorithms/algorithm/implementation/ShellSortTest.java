package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.BeforeEach;


class ShellSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new ShellSort(DefaultComponentsProvider.getDataGenerator());
    }
}

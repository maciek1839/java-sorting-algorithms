package com.showmeyourcode.projects.algorithms.algorithm;

import org.junit.jupiter.api.BeforeEach;


public class ShellSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new ShellSort();
    }
}

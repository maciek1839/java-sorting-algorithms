package com.showmeyourcode.projects.algorithms.algorithm;

import org.junit.jupiter.api.BeforeEach;

/**
 * Created by Maćko z Zarzecza on 2016-11-05.
 */
public class SelectionSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new SelectionSort();
    }
}

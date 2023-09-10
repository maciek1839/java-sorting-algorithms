package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import org.junit.jupiter.api.BeforeEach;

class CocktailShakerSortTest extends AlgorithmTestClassBase {

    @BeforeEach
    @Override
    void setProperAlgorithm() {
        this.algorithm = new CocktailShakerSort(algorithmDataGenerator);
    }
}

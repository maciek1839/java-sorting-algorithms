package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class InsertSort extends AlgorithmBase {

    InsertSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N)/O(N^2)";
    }

    @Override
    public String toString() {
        return "Insertion sort ";
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        int iSwapped;
        for (int i = arrayToSort.length - 1; i > 0; i--) {
            for (int j = i; j < arrayToSort.length && arrayToSort[j - 1] > arrayToSort[j]; j++) {
                iSwapped = arrayToSort[j - 1];
                arrayToSort[j - 1] = arrayToSort[j];
                arrayToSort[j] = iSwapped;
            }
        }
        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.INSERT_SORT;
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class BubbleSort extends AlgorithmBase {

    BubbleSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            return new int[]{};
        }

        int valToSwap;
        boolean swapped = true;

        for (int i = 0; i < arrayToSort.length - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    valToSwap = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = valToSwap;
                    swapped = true;
                }
            }
        }
        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.BUBBLE_SORT;
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N)/O(N^2)";
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}

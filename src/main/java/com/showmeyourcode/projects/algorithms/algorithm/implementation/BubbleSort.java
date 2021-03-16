package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class BubbleSort extends AlgorithmBase {

    BubbleSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        int tmpSwappedValue;
        boolean isSwapped = true;

        for (int i = 0; i < arrayToSort.length - 1 && isSwapped; i++) {
            isSwapped = false;
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    tmpSwappedValue = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = tmpSwappedValue;
                    isSwapped = true;
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

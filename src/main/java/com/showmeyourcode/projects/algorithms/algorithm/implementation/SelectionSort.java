package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class SelectionSort extends AlgorithmBase {

    SelectionSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N^2)";
    }


    @Override
    public String toString() {
        return "Selection Sort ";
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        int positionToSwap, valSwapped;

        for (int i = 0; i < arrayToSort.length; i++) {
            positionToSwap = i;
            for (int j = i; j < arrayToSort.length; j++)
                if (arrayToSort[positionToSwap] > arrayToSort[j])
                    positionToSwap = j;

            valSwapped = arrayToSort[i];
            arrayToSort[i] = arrayToSort[positionToSwap];
            arrayToSort[positionToSwap] = valSwapped;
        }
        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SELECTION_SORT;
    }
}

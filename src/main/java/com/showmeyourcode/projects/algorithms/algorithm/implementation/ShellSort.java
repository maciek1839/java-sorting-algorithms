package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class ShellSort extends AlgorithmBase {

    ShellSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        int valToSwap, iHole = arrayToSort.length / 2;
        //start from top to down
        while (iHole > 0) {
            for (int j = iHole; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[j - iHole]) {
                    valToSwap = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j - iHole];
                    arrayToSort[j - iHole] = valToSwap;
                    for (int i = 0; iHole == 1 && j - iHole - 1 - i >= 0 && arrayToSort[j - iHole - i] < arrayToSort[j - iHole - i - 1]; i++) {
                        valToSwap = arrayToSort[j - iHole - i];
                        arrayToSort[j - iHole - i] = arrayToSort[j - iHole - i - 1];
                        arrayToSort[j - iHole - i - 1] = valToSwap;
                    }
                }
            }
            iHole = iHole / 2;
        }

        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SHELL_SORT;
    }

    @Override
    public String toString() {
        return "Shell Sort ";
    }
}

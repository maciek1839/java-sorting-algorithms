package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class ShellSort extends AlgorithmBase {

    ShellSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int valToSwap, gap = inputArray.length / 2;

        while (gap > 0) {
            for (int j = gap; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[j - gap]) {
                    valToSwap = inputArray[j];
                    inputArray[j] = inputArray[j - gap];
                    inputArray[j - gap] = valToSwap;
                    for (int i = 0; gap == 1 && j - gap - 1 - i >= 0 && inputArray[j - gap - i] < inputArray[j - gap - i - 1]; i++) {
                        valToSwap = inputArray[j - gap - i];
                        inputArray[j - gap - i] = inputArray[j - gap - i - 1];
                        inputArray[j - gap - i - 1] = valToSwap;
                    }
                }
            }
            gap = gap / 2;
        }

        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SHELL_SORT;
    }

    @Override
    public String toString() {
        return "Shell Sort";
    }
}

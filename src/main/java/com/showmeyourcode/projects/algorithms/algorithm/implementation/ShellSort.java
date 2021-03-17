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

        int valToSwap, gapDistance = inputArray.length / 2;

        while (gapDistance > 0) {
            for (int j = gapDistance; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[j - gapDistance]) {
                    valToSwap = inputArray[j];
                    inputArray[j] = inputArray[j - gapDistance];
                    inputArray[j - gapDistance] = valToSwap;
                    for (int i = 0; gapDistance == 1 && j - gapDistance - 1 - i >= 0 && inputArray[j - gapDistance - i] < inputArray[j - gapDistance - i - 1]; i++) {
                        valToSwap = inputArray[j - gapDistance - i];
                        inputArray[j - gapDistance - i] = inputArray[j - gapDistance - i - 1];
                        inputArray[j - gapDistance - i - 1] = valToSwap;
                    }
                }
            }
            gapDistance = gapDistance / 2;
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

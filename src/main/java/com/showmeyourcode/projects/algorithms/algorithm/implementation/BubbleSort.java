package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class BubbleSort extends AlgorithmBase {

    BubbleSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int tmpSwappedValue;
        boolean isSwapped = true;

        for (int i = 0; i < inputArray.length - 1 && isSwapped; i++) {
            isSwapped = false;
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    tmpSwappedValue = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = tmpSwappedValue;
                    isSwapped = true;
                }
            }
        }
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.BUBBLE_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Bubble&#160;sort",
                AlgorithmComplexityConstant.O_N,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_1,
                "yes",
                "yes"
        );
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}

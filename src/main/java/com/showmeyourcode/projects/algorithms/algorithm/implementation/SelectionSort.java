package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class SelectionSort extends AlgorithmBase {

    SelectionSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }


    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int positionToSwap, valSwapped;

        for (int i = 0; i < inputArray.length; i++) {
            positionToSwap = i;
            for (int j = i; j < inputArray.length; j++) {
                if (inputArray[positionToSwap] > inputArray[j]) {
                    positionToSwap = j;
                }
            }

            valSwapped = inputArray[i];
            inputArray[i] = inputArray[positionToSwap];
            inputArray[positionToSwap] = valSwapped;
        }
        return inputArray;
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SELECTION_SORT;
    }
}

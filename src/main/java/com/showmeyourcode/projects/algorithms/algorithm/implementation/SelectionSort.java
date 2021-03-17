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

        int indexOfTheLowestNumber, tmpSwappedValue;

        for (int i = 0; i < inputArray.length; i++) {
            indexOfTheLowestNumber = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[indexOfTheLowestNumber] > inputArray[j]) {
                    indexOfTheLowestNumber = j;
                }
            }

            if (indexOfTheLowestNumber != i) {
                tmpSwappedValue = inputArray[i];
                inputArray[i] = inputArray[indexOfTheLowestNumber];
                inputArray[indexOfTheLowestNumber] = tmpSwappedValue;
            }
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

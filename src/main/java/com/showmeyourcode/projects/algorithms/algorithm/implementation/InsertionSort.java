package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class InsertionSort extends AlgorithmBase {

    InsertionSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int swappedValue;
        for (int i = inputArray.length - 1; i > 0; i--) {
            for (int j = i; j < inputArray.length && inputArray[j - 1] > inputArray[j]; j++) {
                swappedValue = inputArray[j - 1];
                inputArray[j - 1] = inputArray[j];
                inputArray[j] = swappedValue;
            }
        }
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.INSERTION_SORT;
    }

    @Override
    public String toString() {
        return "Insertion sort";
    }
}

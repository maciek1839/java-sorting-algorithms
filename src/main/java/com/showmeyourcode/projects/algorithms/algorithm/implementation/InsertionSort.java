package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class InsertionSort extends AlgorithmBase {

    public InsertionSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        for (int i = 1; i < inputArray.length; ++i) {
            int key = inputArray[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position.
            // Then insert the key between lower and greater elements.
            while (j > -1 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
            }
            inputArray[j + 1] = key;
        }
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.INSERTION_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Insertion&#160;sort  ",
                AlgorithmComplexityConstant.O_N,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_1,
                YES,
                YES
        );
    }

    @Override
    public String toString() {
        return "Insertion sort";
    }
}

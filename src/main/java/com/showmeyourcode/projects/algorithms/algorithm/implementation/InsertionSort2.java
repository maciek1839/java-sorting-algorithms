package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Another implementation of Insertion Sort.
 */
public class InsertionSort2 extends InsertionSort {

    public InsertionSort2(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        for (int i = inputArray.length - 1; i > 0; i--) {
            for (int j = i; j < inputArray.length && inputArray[j - 1] > inputArray[j]; j++) {
                var tmp = inputArray[j - 1];
                inputArray[j - 1] = inputArray[j];
                inputArray[j] = tmp;
            }
        }
        return inputArray;
    }
}

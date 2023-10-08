package com.showmeyourcode.projects.algorithms.algorithm.implementation;


import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation only support non-negative integers.
 * Reference: https://www.programiz.com/dsa/counting-sort
 */
public class CountingSort2 extends CountingSort {

    public CountingSort2(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int size = inputArray.length;
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = inputArray[0];
        for (int i = 1; i < size; i++) {
            if (inputArray[i] > max)
                max = inputArray[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[inputArray[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[inputArray[i]] - 1] = inputArray[i];
            count[inputArray[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            inputArray[i] = output[i];
        }

        return inputArray;
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
/**
 * This implementation uses a middle element as the pivot.
 * Reference: https://www.programcreek.com/2012/11/quicksort-array-in-java/
 */
public class QuickSort2 extends QuickSort {

    public QuickSort2(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        quicksort(arrayToSort, 0, arrayToSort.length - 1);

        return arrayToSort;
    }

    private void quicksort(int[] dataToSort, int startIndex, int endIndex) {

        int leftIndex = startIndex, rightIndex = endIndex;//NOSONAR
        int pivotValue = dataToSort[(startIndex + endIndex) / 2];

        while (leftIndex <= rightIndex) {
            while (dataToSort[leftIndex] < pivotValue) {
                leftIndex++;
            }

            while (dataToSort[rightIndex] > pivotValue) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                int tmpValue = dataToSort[leftIndex];
                dataToSort[leftIndex] = dataToSort[rightIndex];
                dataToSort[rightIndex] = tmpValue;
                leftIndex++;
                rightIndex--;
            }
        }
        if (startIndex < rightIndex) {
            quicksort(dataToSort, startIndex, rightIndex);
        }

        if (leftIndex < endIndex) {
            quicksort(dataToSort, leftIndex, endIndex);
        }
    }
}

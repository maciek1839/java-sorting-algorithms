package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * This implementation uses the pivot as median.
 * todo: check implementation
 */
public class QuickSort extends AlgorithmBase {

    QuickSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String toString() {
        return "Quick sort";
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        sortWithPivot(arrayToSort, 0, arrayToSort.length - 1);

        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.QUICK_SORT;
    }

    private void sortWithPivot(int[] dataToSort, int startIndex, int endIndex) {

        int leftIndex = startIndex, rightIndex = endIndex;//NOSONAR
        int pivot = dataToSort[(startIndex + endIndex) / 2];

        while (leftIndex <= rightIndex) {
            while (dataToSort[leftIndex] < pivot)
                leftIndex++;
            while (dataToSort[rightIndex] > pivot)
                rightIndex--;
            if (leftIndex <= rightIndex) {
                int tmpValue = dataToSort[leftIndex];
                dataToSort[leftIndex] = dataToSort[rightIndex];
                dataToSort[rightIndex] = tmpValue;
                leftIndex++;
                rightIndex--;
            }
        }
        if (startIndex < rightIndex) {
            sortWithPivot(dataToSort, startIndex, rightIndex);
        }

        if (leftIndex < endIndex) {
            sortWithPivot(dataToSort, leftIndex, endIndex);
        }
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * This implementation uses a middle element as the pivot and it's preferred one
 * because the other uses the pivot as the last element causes java.lang.StackOverflowError exception.
 * Reference: https://www.programcreek.com/2012/11/quicksort-array-in-java/
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

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Quick&#160;sort",
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_LOG_N,
                "no",
                "yes"
        );
    }

    private void sortWithPivot(int[] dataToSort, int startIndex, int endIndex) {

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
            sortWithPivot(dataToSort, startIndex, rightIndex);
        }

        if (leftIndex < endIndex) {
            sortWithPivot(dataToSort, leftIndex, endIndex);
        }
    }
}

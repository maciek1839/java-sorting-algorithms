package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Reference: https://www.programiz.com/dsa/quick-sort
 */
public class QuickSort extends AlgorithmBase {

    public QuickSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        quickSort(arrayToSort, 0, arrayToSort.length - 1);

        return arrayToSort;
    }

    private void quickSort(int[] array, int leftIdx, int rightIdx) {
        if (leftIdx < rightIdx) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pivotIdx = partition(array, leftIdx, rightIdx);

            // recursive call on the left of pivot
            quickSort(array, leftIdx, pivotIdx - 1);

            // recursive call on the right of pivot
            quickSort(array, pivotIdx + 1, rightIdx);
        }
    }

    private int partition(int[] array, int leftIdx, int rightIdx) {

        // choose the rightmost element as pivot
        int pivot = array[rightIdx];

        // pointer for greater element
        int i = (leftIdx - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = leftIdx; j < rightIdx; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                swap(array, j, i);
            }
        }

        // swap the pivot element with the greater element specified by i
        swap(array, i + 1, rightIdx);

        // return the position from where partition is done
        return (i + 1);
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    @Override
    public String toString() {
        return "Quick sort";
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
                NO,
                YES
        );
    }
}

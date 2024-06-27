package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

import java.util.Objects;

/**
 * Reference: https://javachallengers.com/merge-sort-with-java/
 */
public class MergeSort extends AlgorithmBase {

    public MergeSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (inputArray == null || inputArray.length <= 1) {
            return Objects.isNull(inputArray) ? new int[0] : inputArray;
        }

        int mid = inputArray.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[inputArray.length - mid];

        // System.arraycopy() is C code, it operates directly on your array, it does not return any values,
        // and because of that it should operate much faster than Array.copyOf().
        // Use System.arraycopy() because of performance. Use Array.copyOf() for cleaner code.
        // https://stackoverflow.com/questions/2589741/what-is-more-efficient-system-arraycopy-or-arrays-copyof
        System.arraycopy(inputArray, 0, leftArray, 0, mid);
        System.arraycopy(inputArray, mid, rightArray, 0, inputArray.length - mid);

        sortData(leftArray);
        sortData(rightArray);
        merge(leftArray, rightArray, inputArray);

        return inputArray;
    }

    void merge(int[] leftArray, int[] rightArray, int[] array) {
        int i = 0, j = 0, k = 0; //NOSONAR

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    @Override
    public String toString() {
        return "Merge sort";
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.MERGE_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Merge&#160;sort",
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N,
                YES,
                NO
        );
    }
}

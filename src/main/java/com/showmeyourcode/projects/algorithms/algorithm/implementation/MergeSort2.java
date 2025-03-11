package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

import java.util.Objects;

/**
 * Reduce temporary allocations by avoid returning new arrays.
 */
public class MergeSort2 extends AlgorithmBase {

    public MergeSort2(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (inputArray == null || inputArray.length < 2) {
            return Objects.isNull(inputArray) ? new int[0] : inputArray;
        }
        mergeSort(inputArray, 0, inputArray.length - 1, new int[inputArray.length]);
        return inputArray;
    }

    private void mergeSort(int[] arr, int startIdx, int endIdx, int[] temp) {
        if (startIdx >= endIdx) {
            return;
        }

        int midIdx = startIdx + (endIdx - startIdx) / 2;

        mergeSort(arr, startIdx, midIdx, temp);
        mergeSort(arr, midIdx + 1, endIdx, temp);
        merge(arr, startIdx, midIdx, endIdx, temp);
    }

    private void merge(int[] arr, int startIdx, int midIdx, int endIdx, int[] temp) {
        System.arraycopy(arr, startIdx, temp, startIdx, endIdx - startIdx + 1);

        int left = startIdx, right = midIdx + 1, current = startIdx;

        while (left <= midIdx && right <= endIdx) {
            arr[current++] = (temp[left] <= temp[right]) ? temp[left++] : temp[right++];
        }

        while (left <= midIdx) {
            arr[current++] = temp[left++];
        }
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.MERGE_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Merge Sort 2",
                AlgorithmComplexityConstant.O_N_LOG_N,  // Best Case
                AlgorithmComplexityConstant.O_N_LOG_N,  // Average Case
                AlgorithmComplexityConstant.O_N_LOG_N,  // Worst Case
                AlgorithmComplexityConstant.O_N,        // Space Complexity (Auxiliary)
                YES,
                NO
        );
    }
}

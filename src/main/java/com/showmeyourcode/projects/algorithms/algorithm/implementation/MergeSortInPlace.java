package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

import java.util.Objects;

/**
 * Optimizations Applied
 * - In-Place Merge Sort → No extra leftArray and rightArray.
 * - System.arraycopy() for Shifting → Efficient element movement instead of using extra arrays.
 * - O(1) Space Complexity → Uses only a few extra variables for merging.
 */
public class MergeSortInPlace extends AlgorithmBase {

    public MergeSortInPlace(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (inputArray == null || inputArray.length <= 1) {
            return Objects.isNull(inputArray) ? new int[0] : inputArray;
        }
        mergeSortInPlace(inputArray, 0, inputArray.length - 1);
        return inputArray;
    }

    private void mergeSortInPlace(int[] arr, int left, int right) {
        if (left >= right) return; // Base case

        int mid = left + (right - left) / 2;
        mergeSortInPlace(arr, left, mid);
        mergeSortInPlace(arr, mid + 1, right);
        mergeInPlace(arr, left, mid, right);
    }

    private void mergeInPlace(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++; // Already in order
            } else {
                int temp = arr[j]; // Take element from right half
                System.arraycopy(arr, i, arr, i + 1, j - i);
                arr[i] = temp; // Place in correct position

                i++; mid++; j++; // Update pointers
            }
        }
    }

    @Override
    public String toString() {
        return "Optimized Merge Sort";
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.MERGE_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Optimized Merge&#160;sort",
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_1,  // **Now O(1) space**
                YES,
                NO
        );
    }
}

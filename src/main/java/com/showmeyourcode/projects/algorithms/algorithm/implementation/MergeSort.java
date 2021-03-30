package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Reference: https://www.geeksforgeeks.org/merge-sort/
 */
public class MergeSort extends AlgorithmBase {

    MergeSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        divideIntoParts(inputArray, 0, inputArray.length - 1);

        return inputArray;
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
                "yes",
                "no"
        );
    }

    private void divideIntoParts(int[] dataToSort, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        divideIntoParts(dataToSort, leftIndex, middleIndex);
        divideIntoParts(dataToSort, middleIndex + 1, rightIndex);
        mergeParts(dataToSort, leftIndex, middleIndex, rightIndex);
    }

    private void mergeParts(int[] dataToSort, int leftIndex, int middleIndex, int rightIndex) {
        int n1 = middleIndex - leftIndex + 1;
        int n2 = rightIndex - middleIndex;

        int[] leftPart = new int[n1], rightPart = new int[n2];//NOSONAR

        System.arraycopy(dataToSort, leftIndex, leftPart, 0, n1);
        System.arraycopy(dataToSort, middleIndex + 1, rightPart, 0, n2);

        int i = 0, j = 0, initialIndexOfMergedParts = leftIndex;//NOSONAR

        while (i < n1 && j < n2) {
            if (leftPart[i] <= rightPart[j]) {
                dataToSort[initialIndexOfMergedParts] = leftPart[i];
                i++;
            } else {
                dataToSort[initialIndexOfMergedParts] = rightPart[j];
                j++;
            }
            initialIndexOfMergedParts++;
        }

        while (i < n1) {
            dataToSort[initialIndexOfMergedParts] = leftPart[i];
            i++;
            initialIndexOfMergedParts++;
        }

        while (j < n2) {
            dataToSort[initialIndexOfMergedParts] = rightPart[j];
            j++;
            initialIndexOfMergedParts++;
        }
    }

    @Override
    public String toString() {
        return "Merge sort";
    }
}

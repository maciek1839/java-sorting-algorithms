package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

// todo: check implementation
public class MergeSort extends AlgorithmBase {

    MergeSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        for (int i_partSize = 1; i_partSize < inputArray.length; i_partSize = i_partSize * 2)
            inputArray = mergeParts(inputArray, i_partSize);
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.MERGE_SORT;
    }

    private int[] mergeParts(int[] data, int partSize) {

        int leftPart = 0, leftStart = 0, rightStart = partSize, rightPart = partSize;
        int[] sortedElements = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (leftStart - leftPart == partSize && rightStart - rightPart != partSize) {
                sortedElements[i] = data[rightStart];
                rightStart++;
            } else if ((rightStart - rightPart == partSize || rightStart >= data.length) && leftStart - leftPart < partSize) {
                sortedElements[i] = data[leftStart];
                leftStart++;
            } else if (data[leftStart] < data[rightStart]) {
                sortedElements[i] = data[leftStart];
                leftStart++;
            } else {
                sortedElements[i] = data[rightStart];
                rightStart++;
            }
            //check if each segmenet's element was compared
            if (leftStart - leftPart == partSize && rightStart - rightPart == partSize) {
                leftPart += 2 * partSize;
                leftStart = leftPart;
                rightPart += 2 * partSize;
                rightStart = rightPart;
            }
        }
        return sortedElements;
    }

    @Override
    public String toString() {
        return "Merge sort";
    }
}

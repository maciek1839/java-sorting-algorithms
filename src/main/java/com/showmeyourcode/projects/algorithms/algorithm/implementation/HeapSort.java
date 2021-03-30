package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Please notice that the pseudocode use a different array notation.
 * As a first array index treats 1 but according to Java it starts with 0.
 * Reference: https://java2blog.com/heap-sort-in-java/
 */
public class HeapSort extends AlgorithmBase {

    HeapSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        buildMaxHeap(inputArray);
        int heapSize = inputArray.length - 1;
        for (int i = heapSize; i > 0; i--) {
            int lowestHeapIndex = 0;
            exchange(inputArray, lowestHeapIndex, i);
            heapSize -= 1;
            maxHeapify(inputArray, lowestHeapIndex, heapSize);
        }

        return inputArray;
    }

    @Override
    public String toString() {
        return "Heap Sort";
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.HEAP_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Heap&#160;sort",
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_N_LOG_N,
                AlgorithmComplexityConstant.O_1,
                "no",
                "yes"
        );
    }

    private void buildMaxHeap(int[] data) {
        int heapSize = data.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(data, i, heapSize);
        }
    }

    private void exchange(int[] dataToSort, int index1, int index2) {
        int tmpValue = dataToSort[index1];
        dataToSort[index1] = dataToSort[index2];
        dataToSort[index2] = tmpValue;
    }

    private void maxHeapify(int[] dataToSort, int index, int heapSize) {
        int leftIndex = 2 * index + 1, rightIndex = 2 * index + 2, largestValueIndex;//NOSONAR
        if (leftIndex <= heapSize && dataToSort[leftIndex] > dataToSort[index]) {
            largestValueIndex = leftIndex;
        } else {
            largestValueIndex = index;
        }

        if (rightIndex <= heapSize && dataToSort[rightIndex] > dataToSort[largestValueIndex]) {
            largestValueIndex = rightIndex;
        }

        if (largestValueIndex != index) {
            exchange(dataToSort, index, largestValueIndex);
            maxHeapify(dataToSort, largestValueIndex, heapSize);
        }
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Please notice that the pseudocode use a different array notation.
 * As a first array index treats 1 but according to Java it starts with 0.
 * Reference: https://java2blog.com/heap-sort-in-java/
 */
public class HeapSort extends AlgorithmBase {

    public HeapSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        buildMaxHeap(inputArray);

        int lastElementIdx = inputArray.length - 1;
        int rootHeapIdx = 0;

        for (int i = lastElementIdx; i > 0; i--) {
            exchange(inputArray, rootHeapIdx, i);
            lastElementIdx -= 1;
            heapify(inputArray, rootHeapIdx, lastElementIdx);
        }

        return inputArray;
    }

    // A max-heap is a complete binary tree in which
    // the value in each internal node is greater than or equal
    // to the values in the children of that node.
    //
    // index of last non-leaf node = floor of (number of nodes)/2 - 1.
    // Ref: https://builtin.com/software-engineering-perspectives/heapify-heap-tree-cpp
    private void buildMaxHeap(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            int lastIdx = data.length - 1;
            heapify(data, i, lastIdx);
        }
    }

    private void exchange(int[] dataToSort, int index1, int index2) {
        int tmpValue = dataToSort[index1];
        dataToSort[index1] = dataToSort[index2];
        dataToSort[index2] = tmpValue;
    }

    private void heapify(int[] dataToSort, int currentIdx, int lastHeapIdx) {
        int leftIndex = 2 * currentIdx + 1, rightIndex = 2 * currentIdx + 2, largestValueIndex;//NOSONAR
        if (leftIndex <= lastHeapIdx && dataToSort[leftIndex] > dataToSort[currentIdx]) {
            largestValueIndex = leftIndex;
        } else {
            largestValueIndex = currentIdx;
        }

        if (rightIndex <= lastHeapIdx && dataToSort[rightIndex] > dataToSort[largestValueIndex]) {
            largestValueIndex = rightIndex;
        }

        if (largestValueIndex != currentIdx) {
            exchange(dataToSort, currentIdx, largestValueIndex);
            heapify(dataToSort, largestValueIndex, lastHeapIdx);
        }
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
                NO,
                YES
        );
    }
}

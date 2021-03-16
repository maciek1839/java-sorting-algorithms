package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class HeapSort extends AlgorithmBase {


    HeapSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N*LOG N)";
    }

    @Override
    public String toString() {
        return "Heap Sort ";
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        //create max heap
        for (int i = 1; i <= arrayToSort.length; i++)
            arrayToSort = createMaxHeap(arrayToSort, i);
        //strip heap
        int iTmp;
        for (int i = 0; i < arrayToSort.length; i++) {
            iTmp = arrayToSort[arrayToSort.length - 1 - i];
            arrayToSort[arrayToSort.length - 1 - i] = arrayToSort[0];
            arrayToSort[0] = iTmp;
            arrayToSort = checkChildren(arrayToSort, 0, arrayToSort.length - i - 1);
        }
        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.HEAP_SORT;
    }

    //change order down in heap if necessary
    private int[] checkChildren(int[] heap, int i, int amountElements) {

        if (amountElements > 0 && i < amountElements) {
            int tmp, left, right;
            left = 2 * i;
            right = 2 * i + 1;
            if (left < amountElements && heap[i] < heap[left]) {
                tmp = heap[i];
                heap[i] = heap[left];
                heap[left] = tmp;
                heap = checkChildren(heap, left, amountElements);
            }
            if (right < amountElements && heap[i] < heap[right]) {
                tmp = heap[i];
                heap[i] = heap[right];
                heap[right] = tmp;
                heap = checkChildren(heap, right, amountElements);
            }
        }
        return heap;
    }

    //change order up in heap if necessary
    private int[] checkParent(int[] heap, int i) {
        int iTmp, iParent = i / 2;
        while (i != 0 && iParent >= 0) {
            if (heap[i] > heap[iParent]) {
                iTmp = heap[i];
                heap[i] = heap[iParent];
                heap[iParent] = iTmp;
                i = iParent;
                iParent = iParent / 2;
            } else break;
        }
        return heap;
    }

    private int[] createMaxHeap(int[] data, int amountElements) {
        int iTmp;
        for (int i = 1; i < amountElements; i++) {
            if (data[i / 2] < data[i]) {
                iTmp = data[i];
                data[i] = data[i / 2];
                data[i / 2] = iTmp;
                checkParent(data, i / 2);//check higher levels
            }
        }
        return data;
    }
}

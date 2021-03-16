package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

//todo: check implementation
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

    //we use index of table's elements!
    private int[] sortWithPivot(int[] tData, int from, int to) {

        int left = from, right = to;
        int tmp;
        int pivot = tData[(from + to) / 2];

        while (left <= right) {
            while (tData[left] < pivot)
                left++;
            while (tData[right] > pivot)
                right--;
            if (left <= right) {
                tmp = tData[left];
                tData[left] = tData[right];
                tData[right] = tmp;
                left++;
                right--;
            }
        }

        if (from < right)
            sortWithPivot(tData, from, right);
        if (left < to)
            sortWithPivot(tData, left, to);
        return tData;
    }
}

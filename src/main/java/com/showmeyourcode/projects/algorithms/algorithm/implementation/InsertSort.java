package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class InsertSort extends AlgorithmBase {

    InsertSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N)/O(N^2)";
    }

    /*
        PSEUDOCODE
            more on the Internet

        PERFORMANCE
            Worst-case performance O(n^{2})
            Best-case performance  O(n)
            Worst-case space complexity O(1)
            Stability? Yes
    */
    @Override
    public String toString() {
        return "Insertion sort ";
    }

    @Override
    public int[] sortData(int[] data) {
        if (data == null || data.length == 0) {
            return new int[]{};
        }

        int iSwapped;
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = i; j < data.length && data[j - 1] > data[j]; j++) {
                iSwapped = data[j - 1];
                data[j - 1] = data[j];
                data[j] = iSwapped;
            }
        }
        return data;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.INSERT_SORT;
    }
}

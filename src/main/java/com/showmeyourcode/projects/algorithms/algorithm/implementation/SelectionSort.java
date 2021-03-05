package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class SelectionSort extends AlgorithmBase {

    SelectionSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N^2)";
    }

    /*
    PSEUDOCODE
        more on the Internet

    PERFORMANCE
        Worst-case performance O(n^{2})
        Best-case performance  O(n^{2})
        Worst-case space complexity	O(1)
        Stability? No
     */
    @Override
    public String toString() {
        return "Selection Sort ";
    }

    @Override
    public int[] sortData(int[] data) {
        if (data == null || data.length == 0) {
            return new int[]{};
        }

        int positionToSwap, valSwapped;

        for (int i = 0; i < data.length; i++) {
            positionToSwap = i;
            for (int j = i; j < data.length; j++)
                if (data[positionToSwap] > data[j])
                    positionToSwap = j;

            valSwapped = data[i];
            data[i] = data[positionToSwap];
            data[positionToSwap] = valSwapped;
        }
        return data;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SELECTION_SORT;
    }
}

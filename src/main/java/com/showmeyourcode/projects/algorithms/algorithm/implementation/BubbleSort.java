package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class BubbleSort extends AlgorithmBase {

    BubbleSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] tData) {
        if (tData == null || tData.length == 0) {
            return new int[]{};
        }

        int valToSwap;
        boolean swapped = true;

        for (int i = 0; i < tData.length - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < tData.length - i - 1; j++) {
                if (tData[j] > tData[j + 1]) {
                    valToSwap = tData[j];
                    tData[j] = tData[j + 1];
                    tData[j + 1] = valToSwap;
                    swapped = true;
                }
            }
        }
        return tData;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.BUBBLE_SORT;
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N)/O(N^2)";
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class ShakerSort extends AlgorithmBase {

    ShakerSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String toString() {
        return "Shaker Sort ";
    }

    @Override
    public int[] sortData(int[] arrayToSort) {
        if (isArrayEmpty(arrayToSort)) {
            return new int[]{};
        }

        int valToSwap, iLoop = 0;//i_loop means the same as int i in for loop
        boolean isSwapped;

        do {
            isSwapped = false;
            for (int j = iLoop; j < arrayToSort.length - iLoop - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    valToSwap = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = valToSwap;
                    isSwapped = true;
                }
            }
            //means that array is sorted and we dont have to do more comparisions
            if (!isSwapped) break;
            for (int j = arrayToSort.length - iLoop - 1; j > iLoop; j--) {
                if (arrayToSort[j] < arrayToSort[j - 1]) {
                    valToSwap = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j - 1];
                    arrayToSort[j - 1] = valToSwap;
                    isSwapped = true;
                }
            }
            iLoop++;
        } while (isSwapped);

        return arrayToSort;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SHAKER_SORT;
    }
}

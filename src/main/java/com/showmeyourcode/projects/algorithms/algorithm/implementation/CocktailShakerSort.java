package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class CocktailShakerSort extends AlgorithmBase {

    CocktailShakerSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int valToSwap, tmpArrayIndex = 0;
        boolean shouldSortFromTheRight;

        do {
            shouldSortFromTheRight = false;
            for (int j = tmpArrayIndex; j < inputArray.length - tmpArrayIndex - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    valToSwap = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = valToSwap;
                    shouldSortFromTheRight = true;
                }
            }

            if (!shouldSortFromTheRight) {
                break;
            }
            for (int j = inputArray.length - tmpArrayIndex - 1; j > tmpArrayIndex; j--) {
                if (inputArray[j] < inputArray[j - 1]) {
                    valToSwap = inputArray[j];
                    inputArray[j] = inputArray[j - 1];
                    inputArray[j - 1] = valToSwap;
                }
            }
            tmpArrayIndex++;
        } while (tmpArrayIndex < inputArray.length);

        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.COCKTAIL_SHAKER_SORT;
    }

    @Override
    public String toString() {
        return "Cocktail Shaker Sort";
    }
}

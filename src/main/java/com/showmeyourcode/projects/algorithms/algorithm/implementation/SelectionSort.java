package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class SelectionSort extends AlgorithmBase {

    public SelectionSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        for (int i = 0; i < inputArray.length; i++) {
            var lowestValueIndex = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[lowestValueIndex] > inputArray[j]) {
                    lowestValueIndex = j;
                }
            }

            if (lowestValueIndex != i) {
                var tmp = inputArray[i];
                inputArray[i] = inputArray[lowestValueIndex];
                inputArray[lowestValueIndex] = tmp;
            }
        }
        return inputArray;
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SELECTION_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Selection&#160;sort",
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_1,
                NO,
                YES
        );
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public class ShellSort extends AlgorithmBase {

    ShellSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int gapDistance = inputArray.length / 2;

        while (gapDistance != 0) {
            int currentIndex = gapDistance;
            int lastIndex = inputArray.length - 1;
            while (currentIndex <= lastIndex) {
                int tmpValue = inputArray[currentIndex];
                int walkerIndex = currentIndex - gapDistance;
                while (walkerIndex >= 0 && tmpValue < inputArray[walkerIndex]) {
                    inputArray[walkerIndex + gapDistance] = inputArray[walkerIndex];
                    walkerIndex -= gapDistance;
                }
                inputArray[walkerIndex + gapDistance] = tmpValue;
                currentIndex++;
            }
            gapDistance = gapDistance / 2;
        }

        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.SHELL_SORT;
    }

    @Override
    public String toString() {
        return "Shell Sort";
    }
}

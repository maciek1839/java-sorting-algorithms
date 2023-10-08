package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Optimized Bubble Sort
 *
 * In order to optimize the algorithm, a new variable may be introduced, which is called swap.
 * The value of swap is set to be true if there is an element swap. If not, it is set to be false.
 * If no swapping occurs after an iteration, the value of swapping will be false.
 * This indicates that the elements have already been sorted and that no more iterations are required.
 * This will speed up the process and optimize bubble sort efficiency.
 */
public class BubbleSort extends AlgorithmBase {

    public BubbleSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        boolean isSwapped = true;
        // Should the "tmp" variable be declared outside the loop to improve performance?
        // No, there is no difference in performance as the compiler optimized the code to get the best performance.
        // Ref: https://stackoverflow.com/questions/407255/difference-between-declaring-variables-before-or-in-loop

        for (int i = 0; i < inputArray.length - 1 && isSwapped; i++) {
            isSwapped = false;
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    var tmp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = tmp;
                    isSwapped = true;
                }
            }
        }
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.BUBBLE_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Bubble&#160;sort",
                AlgorithmComplexityConstant.O_N,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_N_2,
                AlgorithmComplexityConstant.O_1,
                YES,
                YES
        );
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}

package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

/**
 * Optimized Cocktail Shaker Sort
 * <p>
 * In order to optimize, a new variable may be introduced, which is called swap (similarly to Bubble Sort).
 * The value of swap is set to be true if there is an element swap. If not, it is set to be false.
 * If no swapping occurs after an iteration, the value of swapping will be false.
 * This indicates that the elements have already been sorted and that no more iterations are required.
 */
public class CocktailShakerSort extends AlgorithmBase {

    public CocktailShakerSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        var isSwapped = true;

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

            // If nothing moved, then array is sorted.
            // Otherwise, reset the swapped flag so that it
            // can be used in the next stage.
            if (!isSwapped) {
                break;
            } else {
                isSwapped = false;
            }
            // move the "j" index back by one as an item at the end is in its rightful spot
            for (int j = (inputArray.length - i - 1) - 1; j > 0; j--) {
                if (inputArray[j] < inputArray[j - 1]) {
                    var tmp = inputArray[j];
                    inputArray[j] = inputArray[j - 1];
                    inputArray[j - 1] = tmp;
                    isSwapped = true;
                }
            }
        }
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.COCKTAIL_SHAKER_SORT;
    }

    @Override
    public AlgorithmMetadata getMetadata() {
        return new AlgorithmMetadata(
                "Cocktail&#160;Shaker&#160;sort <br/> (Bidirectional&#160;bubble&#160;sort)  ",
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
        return "Cocktail Shaker Sort";
    }
}

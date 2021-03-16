package com.showmeyourcode.projects.algorithms.algorithm.implementation;


import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of the counting sort includes following modifications:
 * - reduce the auxiliary array size to a range of existing elements in the input array (the algorithm is not in-place sorting),
 * - because of the above modification for searching the lowest and the highest value, the complexity change -> O(2n+m) and 0(M)-memory,
 * - reuse the same input array as the output array (make the algorithm stable).
 */
public class CountingSort extends AlgorithmBase {

    CountingSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public int[] sortData(int[] inputArray) {
        if (isArrayEmpty(inputArray)) {
            return new int[]{};
        }

        int theLowest = inputArray[0], theHighest = inputArray[0], listCapacity;

        for (int arrayNumber : inputArray) {
            if (arrayNumber < theLowest)
                theLowest = arrayNumber;
            else if (arrayNumber > theHighest)
                theHighest = arrayNumber;
        }
        /*
         * See this example:
         * 325-320=5 but 6 numbers -> 320,321,322,323,324,325
         *
         * The array stores value from the lowest to the biggest.
         */
        listCapacity = theHighest - theLowest + 1;

        List<Tuple2<Integer, Integer>> lowHighValues = new ArrayList<>(listCapacity);
        for (int i = 0; i < listCapacity; i++) {
            lowHighValues.add(i, new Tuple2<>(theLowest + i, 0));
        }

        for (int singleNumberToSort : inputArray) {
            int arrayIndex = singleNumberToSort - theLowest;
            Tuple2<Integer, Integer> currentNumberCount = lowHighValues.get(arrayIndex);
            lowHighValues.set(arrayIndex, new Tuple2<>(currentNumberCount._1, currentNumberCount._2() + 1));
        }

        int inputArrayIndex = 0;
        for (int i = 0; inputArrayIndex < inputArray.length && i < listCapacity; i++) {
            Tuple2<Integer, Integer> numberCount = lowHighValues.get(i);
            int singleNumberCount = numberCount._2();
            if (singleNumberCount > 0) {
                while (singleNumberCount > 0) {
                    inputArray[inputArrayIndex] = numberCount._1();
                    singleNumberCount -= 1;
                    inputArrayIndex += 1;
                }
            }
        }
        return inputArray;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.COUNTING_SORT;
    }


    @Override
    public String toString() {
        return "Counting Sort ";
    }
}

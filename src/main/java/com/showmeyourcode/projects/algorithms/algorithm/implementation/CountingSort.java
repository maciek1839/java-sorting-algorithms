package com.showmeyourcode.projects.algorithms.algorithm.implementation;


import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import io.vavr.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class CountingSort extends AlgorithmBase {

    CountingSort(AlgorithmDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public String getAlgorithmPerformance() {
        return "O(N+M)";
    }

    @Override
    public int[] sortData(int[] tData) {
        if (tData == null || tData.length == 0) {
            return new int[]{};
        }

        int theLowest = tData[0], theHighest = tData[0], listCapacity;

        for (int tDatum : tData) {
            if (tDatum < theLowest)
                theLowest = tDatum;
            else if (tDatum > theHighest)
                theHighest = tDatum;
        }
        listCapacity = theHighest - theLowest + 1;//look at this 325-320=5 but 6 numbers->320,321,322,323,324,325
        //array stores value from the lowest to the biggest
        List<Tuple2<Integer, Integer>> lowHighValues = new ArrayList<>(listCapacity);
        for (int i = 0; i < listCapacity; i++) {
            lowHighValues.add(i, new Tuple2<>(theLowest + i, 0));
        }
        //count each value
        for (int tDatum : tData) {
            lowHighValues.set(tDatum - theLowest, new Tuple2<>(lowHighValues.get(tDatum - theLowest)._1(), lowHighValues.get(tDatum - theLowest)._2() + 1));

        }
        //flush all countered values
        int howMany, tableIndex = 0;
        for (int i = 0; tableIndex < tData.length && i < listCapacity; i++) {
            howMany = lowHighValues.get(i)._2();
            if (howMany > 0) {
                while (howMany > 0) {
                    tData[tableIndex] = lowHighValues.get(i)._1();
                    howMany -= 1;
                    tableIndex += 1;
                }
            }
        }
        return tData;
    }

    @Override
    public AlgorithmType getType() {
        return AlgorithmType.COUNTING_SORT;
    }

    /*
    PSEUDOCODE
        find it on the Internet

    PERFORMANCE
       O(N+M) where N is the number of elements to be sorted and K is the number of possible values in the range.
       but if we add first loop for searching the lowest and the highest value-> 2n+m
       0(M)-memory
     */
    @Override
    public String toString() {
        return "Counting Sort ";
    }
}

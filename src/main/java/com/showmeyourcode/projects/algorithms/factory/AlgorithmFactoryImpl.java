package com.showmeyourcode.projects.algorithms.factory;

import com.showmeyourcode.projects.algorithms.algorithm.*;

public class AlgorithmFactoryImpl implements AlgorithmFactory {

    @Override
    public Algorithm createAlgorithm(AlgorithmType enumVal) {
        switch (enumVal) {
            case BUBBLE_SORT:
                return new BubbleSort();
            case COUNTING_SORT:
                return new CountingSort();
            case HEAP_SORT:
                return new HeapSort();
            case INSERT_SORT:
                return new InsertSort();
            case MERGE_SORT:
                return new MergeSort();
            case QUICK_SORT:
                return new QuickSort();
            case SELECTION_SORT:
                return new SelectionSort();
            case SHAKER_SORT:
                return new ShakerSort();
            case SHELL_SORT:
                return new ShellSort();
            default:
                throw new UnsupportedOperationException(String.format("The algorithm %s is not implemented!", enumVal.toString()));
        }
    }
}

package com.showmeyourcode.projects.algorithms.algorithm;

import com.showmeyourcode.projects.algorithms.generator.DataGenerator;
import com.showmeyourcode.projects.algorithms.model.SortingAppConfiguration;

public class AlgorithmFactoryImpl implements AlgorithmFactory {

    private final DataGenerator dataGenerator;

    public AlgorithmFactoryImpl(SortingAppConfiguration config) {
        dataGenerator = new DataGenerator(config);
    }

    @Override
    public Algorithm createAlgorithm(AlgorithmType enumVal) {
        switch (enumVal) {
            case BUBBLE_SORT:
                return new BubbleSort(dataGenerator);
            case COUNTING_SORT:
                return new CountingSort(dataGenerator);
            case HEAP_SORT:
                return new HeapSort(dataGenerator);
            case INSERT_SORT:
                return new InsertSort(dataGenerator);
            case MERGE_SORT:
                return new MergeSort(dataGenerator);
            case QUICK_SORT:
                return new QuickSort(dataGenerator);
            case SELECTION_SORT:
                return new SelectionSort(dataGenerator);
            case SHAKER_SORT:
                return new ShakerSort(dataGenerator);
            case SHELL_SORT:
                return new ShellSort(dataGenerator);
            default:
                throw new UnsupportedOperationException(String.format("The algorithm %s is not implemented!", enumVal.toString()));
        }
    }
}

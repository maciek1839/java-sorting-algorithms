package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmFactory implements AbstractAlgorithmFactory {

    private final AlgorithmDataGenerator dataGenerator;

    public AlgorithmFactory(SortingAppConfiguration config) {
        dataGenerator = new AlgorithmDataGenerator(config);
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

    @Override
    public List<Algorithm> creatAllAvailableAlgorithms() {
        List<Algorithm> resultList = new ArrayList();
        for (AlgorithmType type : AlgorithmType.values()) {
            resultList.add(createAlgorithm(type));
        }
        return resultList;
    }
}

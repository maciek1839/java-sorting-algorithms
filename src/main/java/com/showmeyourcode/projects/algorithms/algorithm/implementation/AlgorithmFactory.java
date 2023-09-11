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
        return switch (enumVal) {
            case BUBBLE_SORT -> new BubbleSort(dataGenerator);
            case COUNTING_SORT -> new CountingSort(dataGenerator);
            case HEAP_SORT -> new HeapSort(dataGenerator);
            case INSERTION_SORT -> new InsertionSort(dataGenerator);
            case MERGE_SORT -> new MergeSort(dataGenerator);
            case QUICK_SORT -> new QuickSort(dataGenerator);
            case SELECTION_SORT -> new SelectionSort(dataGenerator);
            case COCKTAIL_SHAKER_SORT -> new CocktailShakerSort(dataGenerator);
            case SHELL_SORT -> new ShellSort(dataGenerator);
            default -> throw new UnsupportedOperationException(String.format("The algorithm %s is not implemented!", enumVal.toString()));
        };
    }

    @Override
    public List<Algorithm> creatAllAvailableAlgorithms() {
        List<Algorithm> resultList = new ArrayList<>();
        for (AlgorithmType type : AlgorithmType.values()) {
            resultList.add(createAlgorithm(type));
        }
        return resultList;
    }
}

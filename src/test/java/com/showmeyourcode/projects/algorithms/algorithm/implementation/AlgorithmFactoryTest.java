package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


class AlgorithmFactoryTest extends DefaultComponentsProvider {

    static Stream<Arguments> getAlgorithmTypeAndInstance() {
        return Stream.of(
                Arguments.of(AlgorithmType.BUBBLE_SORT, new BubbleSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.COUNTING_SORT, new CountingSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.HEAP_SORT, new HeapSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.INSERTION_SORT, new InsertionSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.MERGE_SORT, new MergeSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.QUICK_SORT, new QuickSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.SELECTION_SORT, new SelectionSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.COCKTAIL_SHAKER_SORT, new CocktailShakerSort(algorithmDataGenerator)),
                Arguments.of(AlgorithmType.SHELL_SORT, new ShellSort(algorithmDataGenerator))
        );
    }

    protected AlgorithmFactory algorithmFactory;

    @BeforeEach
    void setUp() {
        algorithmFactory = new AlgorithmFactory(applicationConfiguration);
    }

    @ParameterizedTest
    @MethodSource("getAlgorithmTypeAndInstance")
    void givePerformanceTest(AlgorithmType type, Algorithm algorithm) {
        assertTrue(algorithmFactory.createAlgorithm(type).getClass().isAssignableFrom(algorithm.getClass()));
    }
}

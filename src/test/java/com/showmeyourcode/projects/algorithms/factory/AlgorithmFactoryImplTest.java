package com.showmeyourcode.projects.algorithms.factory;

import com.showmeyourcode.projects.algorithms.algorithm.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;


class AlgorithmFactoryImplTest {

    AlgorithmFactoryImpl algorithmFactory;

    static Stream<Arguments> getAlgorithmTypeAndInstance() {
        return Stream.of(
                Arguments.of(AlgorithmType.BUBBLE_SORT, new BubbleSort()),
                Arguments.of(AlgorithmType.COUNTING_SORT, new CountingSort()),
                Arguments.of(AlgorithmType.HEAP_SORT, new HeapSort()),
                Arguments.of(AlgorithmType.INSERT_SORT, new InsertSort()),
                Arguments.of(AlgorithmType.MERGE_SORT, new MergeSort()),
                Arguments.of(AlgorithmType.QUICK_SORT, new QuickSort()),
                Arguments.of(AlgorithmType.SELECTION_SORT, new SelectionSort()),
                Arguments.of(AlgorithmType.SHAKER_SORT, new ShakerSort()),
                Arguments.of(AlgorithmType.SHELL_SORT, new ShellSort())
        );
    }

    @BeforeEach
    void setUp() {
        algorithmFactory = new AlgorithmFactoryImpl();
    }

    @AfterEach
    void tearDown() {
        algorithmFactory = null;
    }

    @ParameterizedTest
    @MethodSource("getAlgorithmTypeAndInstance")
    void givePerformanceTest(AlgorithmType type, Algorithm algorithm) {
        assertTrue(algorithmFactory.createAlgorithm(type).getClass().isAssignableFrom(algorithm.getClass()));
    }
}

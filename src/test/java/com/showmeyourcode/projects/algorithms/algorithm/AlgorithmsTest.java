package com.showmeyourcode.projects.algorithms.algorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmsTest {
    static Stream<Arguments> getNameAndPerformanceAndAlgorithms() {
        return Stream.of(
                Arguments.of("O(N)/O(N^2)", "Bubble Sort ", new BubbleSort()),
                Arguments.of("O(N+M)", "Counting Sort ", new CountingSort()),
                Arguments.of("O(N)/O(N^2)", "Insertion sort ", new InsertSort()),
                Arguments.of("O(N*LOG N)", "Merge sort ", new MergeSort())
        );
    }

    @ParameterizedTest
    @MethodSource("getNameAndPerformanceAndAlgorithms")
    void shouldReturnProperPerformanceAndNameForAlgorithm(String expectedPerformance,
                                                          String expectedName,
                                                          Algorithm algorithm) {
        assertEquals(expectedPerformance, algorithm.getAlgorithmPerformance());
        assertEquals(expectedName.trim(), algorithm.toString().trim());
    }
}

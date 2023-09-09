package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmsTest {
    static Stream<Arguments> getNameAndPerformanceAndAlgorithms() {
        return Stream.of(
                Arguments.of("Bubble Sort ", new BubbleSort(DefaultComponentsProvider.getDataGenerator())),
                Arguments.of("Counting Sort ", new CountingSort(DefaultComponentsProvider.getDataGenerator())),
                Arguments.of("Insertion sort ", new InsertionSort(DefaultComponentsProvider.getDataGenerator())),
                Arguments.of("Merge sort ", new MergeSort(DefaultComponentsProvider.getDataGenerator()))
        );
    }

    @ParameterizedTest
    @MethodSource("getNameAndPerformanceAndAlgorithms")
    void shouldReturnProperPerformanceAndNameForAlgorithm(String expectedName, Algorithm algorithm) {
        assertEquals(expectedName.trim(), algorithm.toString().trim());
    }
}

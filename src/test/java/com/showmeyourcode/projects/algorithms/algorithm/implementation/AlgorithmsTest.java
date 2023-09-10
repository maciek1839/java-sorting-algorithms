package com.showmeyourcode.projects.algorithms.algorithm.implementation;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmsTest extends DefaultComponentsProvider {

    private static Stream<Arguments> getNameAndPerformanceAndAlgorithms() {
        return Stream.of(
                Arguments.of("Bubble Sort ", new BubbleSort(algorithmDataGenerator)),
                Arguments.of("Counting Sort ", new CountingSort(algorithmDataGenerator)),
                Arguments.of("Insertion sort ", new InsertionSort(algorithmDataGenerator)),
                Arguments.of("Merge sort ", new MergeSort(algorithmDataGenerator))
        );
    }

    @ParameterizedTest
    @MethodSource("getNameAndPerformanceAndAlgorithms")
    void should_returnProperAlgorithmName_when_InvokingToString(String expectedName, Algorithm algorithm) {
        assertEquals(expectedName.trim(), algorithm.toString().trim());
    }
}

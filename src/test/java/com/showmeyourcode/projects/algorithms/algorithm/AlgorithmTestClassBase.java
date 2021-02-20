package com.showmeyourcode.projects.algorithms.algorithm;

import com.showmeyourcode.projects.algorithms.test_util.AlgorithmDataProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AlgorithmTestClassBase {
    protected Algorithm algorithm;

    public static Stream<Arguments> getDataToSort() {
        return AlgorithmDataProvider.getDataToSort();
    }

    abstract void setProperAlgorithm();

    @AfterEach
    void clear() {
        algorithm = null;
    }

    @Test
    void shouldReturnEmptyArrayWhenDataIsInvalid() {
        assertEquals(0, algorithm.sortData(null).length);
    }

    @ParameterizedTest
    @MethodSource("getDataToSort")
    void shouldProperlySortData(int[] randomOrderData, int[] expectedData) {
        assertArrayEquals(expectedData, algorithm.sortData(randomOrderData));
    }
}

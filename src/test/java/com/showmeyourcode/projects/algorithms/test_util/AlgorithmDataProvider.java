package com.showmeyourcode.projects.algorithms.test_util;

import com.showmeyourcode.projects.algorithms.benchmark.AlgorithmsBenchmarkData;
import com.showmeyourcode.projects.algorithms.benchmark.TestBenchmarkData;
import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.util.stream.Stream;

public class AlgorithmDataProvider {
    public static Stream<Arguments> getDataToSort() throws BenchmarkDataNotFoundException, IOException {
        return Stream.of(
                Arguments.of(new int[0], new int[]{}),
                Arguments.of(new int[]{5, 4, 3, 2, 1, 0}, new int[]{0, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{4, 6, 2, 4, 3, 1}, new int[]{1, 2, 3, 4, 4, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 4, 5}, new int[]{1, 2, 3, 4, 4, 5}),
                Arguments.of(new int[]{-1, 2, 3, 4, -4, 5, 25, -30}, new int[]{-30, -4, -1, 2, 3, 4, 5, 25}),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 1, 5, 5, 5}, new int[]{1, 5, 5, 5, 5, 5, 5, 5, 5, 5}),
                Arguments.of(new int[]{4, 423, 6, 6, -2, 0, 43, -423, 53432, 23, 4423}, new int[]{-423, -2, 0, 4, 6, 6, 23, 43, 423, 4423, 53432}),
                Arguments.of(new int[]{4, 77, 5, 4, 33, 5, 7, 8, 9, 9, 9, 96, 5, 54, 33, 55, 3, 2}, new int[]{2, 3, 4, 4, 5, 5, 5, 7, 8, 9, 9, 9, 33, 33, 54, 55, 77, 96}),
                Arguments.of(
                        DefaultComponentsProvider.getBenchmarkDataGenerator().loadData(AlgorithmsBenchmarkData.FIFTY_THOUSANDS),
                        DefaultComponentsProvider.getBenchmarkDataGenerator().loadData(TestBenchmarkData.SORTED_50K_BENCHMARK_DATA)
                )
        );
    }
}

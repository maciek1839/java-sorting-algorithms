package com.showmeyourcode.projects.algorithms.test_util;

import com.github.javafaker.Faker;
import com.showmeyourcode.projects.algorithms.benchmark.AlgorithmsBenchmarkData;
import com.showmeyourcode.projects.algorithms.benchmark.TestBenchmarkData;
import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class AlgorithmDataProvider extends DefaultComponentsProvider{

    private final static Faker faker = new Faker();

    public static Stream<Arguments> getDataToSort() throws BenchmarkDataNotFoundException, IOException {
        var random200 = getRandomIntArray(200);
        var random500 = getRandomIntArray(500);
        var random1200 = getRandomIntArray(1200);
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
                        benchmarkDataGenerator.loadData(AlgorithmsBenchmarkData.FIFTY_THOUSAND),
                        benchmarkDataGenerator.loadData(TestBenchmarkData.SORTED_50K_BENCHMARK_DATA)
                ),
                Arguments.of(
                        random200,
                        Arrays.stream(random200).sorted().toArray()
                        ),
                Arguments.of(
                        random500,
                        Arrays.stream(random500).sorted().toArray()
                ),
                Arguments.of(
                        random1200,
                        Arrays.stream(random1200).sorted().toArray()
                )
        );
    }

    private static int[] getRandomIntArray(int length){
        var result = new int[length];
        for(int i = 0; i<length;i++){
            result[i] = faker.number().numberBetween(-50,50);
        }
        return result;
    }
}

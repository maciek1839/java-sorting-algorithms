package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BenchmarkAlgorithmDataGeneratorTest {

    @Test
    void should_loadBenchmarkData_when_fileExists() throws IOException {
        var benchmarkDataGenerator = new BenchmarkDataGenerator(StaticValueProvider.getConfig());

        int[] loadedData = benchmarkDataGenerator.loadData(BenchmarkData.TEN_THOUSANDS);

        assertEquals(10000, loadedData.length);
    }
}

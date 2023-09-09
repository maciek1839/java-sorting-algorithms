package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;

class BenchmarkProcessorTest {

    @Test
    void should_generateReportForValidAlgorithms_when_restOfAlgorithmsThrowException() throws BenchmarkDataNotFoundException, IOException {
        var config = DefaultComponentsProvider.getConfig();
        BenchmarkDataGenerator dataGenerator = Mockito.mock(BenchmarkDataGenerator.class);
        Mockito.when(dataGenerator.loadData(any())).then(invocation -> {
            Object[] args = invocation.getArguments();
            AlgorithmsBenchmarkData data = (AlgorithmsBenchmarkData) args[0];
            if (data == AlgorithmsBenchmarkData.FIFTY_THOUSANDS) {
                return new int[]{5, 32, 4, 21, 7};
            } else {
                throw new BenchmarkDataNotFoundException(data);
            }
        });
        BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config);

        List<BenchmarkResultGroup> resultGroups = benchmarkProcessor.getBenchmarkDataReport();
        List<BenchmarkResult> algorithmResults = new ArrayList<>();
        resultGroups.forEach(group -> algorithmResults.addAll(group.getResults()));

        assertEquals(9, algorithmResults.size());
        assertEquals(1, resultGroups.size());
    }
}

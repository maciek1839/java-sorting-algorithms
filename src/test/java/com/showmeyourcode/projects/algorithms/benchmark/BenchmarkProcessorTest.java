package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;

class BenchmarkProcessorTest {

    @Test
    void should_generateReportForValidAlgorithms_when_restOfAlgorithmsThrowException() throws BenchmarkDataNotFoundException, IOException {
        var config = StaticValueProvider.getConfig();
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

        List<BenchmarkResult> result = benchmarkProcessor.getBenchmarkDataReport();

        assertEquals(9, result.size());
    }
}

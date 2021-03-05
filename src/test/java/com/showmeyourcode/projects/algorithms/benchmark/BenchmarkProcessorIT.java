package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BenchmarkProcessorIT {

    @Test
    void should_generateReport_forAllAlgorithms() {
        var config = StaticValueProvider.getConfig();
        BenchmarkDataGenerator dataGenerator = new BenchmarkDataGenerator(config);
        BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config);

        List<BenchmarkResult> result = benchmarkProcessor.getBenchmarkDataReport();

        assertEquals(27, result.size());
    }

    @Test
    @Disabled
    void should_saveReportResult_when_resultListIsNotEmpty() {

    }
}

package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BenchmarkProcessorIT {

    @Test
    void should_generateReport_when_allAlgorithmsLoadData() {
        var config = StaticValueProvider.getConfig();
        BenchmarkDataGenerator dataGenerator = new BenchmarkDataGenerator(config);
        BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config);

        List<BenchmarkResultGroup> resultGroups = benchmarkProcessor.getBenchmarkDataReport();
        List<BenchmarkResult> algorithmResults = new ArrayList<>();
        resultGroups.forEach(group -> algorithmResults.addAll(group.getResults()));

        assertEquals(27, algorithmResults.size());
        assertEquals(3, resultGroups.size());
    }

    @Test
    @Disabled
    void should_saveReportResult_when_resultListIsNotEmpty() {

    }

    @Test
    @Disabled
    void should_createResultsFile_when_itDoesNotExist() {

    }
}

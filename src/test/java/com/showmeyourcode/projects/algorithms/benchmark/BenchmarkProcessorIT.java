package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.exception.CannotCreateReportResultsFileException;
import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BenchmarkProcessorIT {

    @Test
    void should_generateReport_when_allAlgorithmsLoadData() {
        var config = DefaultComponentsProvider.getConfig();
        BenchmarkDataGenerator dataGenerator = new BenchmarkDataGenerator(config);
        BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config);

        List<BenchmarkResultGroup> resultGroups = benchmarkProcessor.getBenchmarkDataReport();
        List<BenchmarkResult> algorithmResults = new ArrayList<>();
        resultGroups.forEach(group -> algorithmResults.addAll(group.getResults()));

        assertEquals(27, algorithmResults.size());
        assertEquals(3, resultGroups.size());
    }

    @Test
    void should_saveReportResult_when_resultIsAvailable() throws CannotCreateReportResultsFileException {
        var tmpFile = String.format("/benchmark/test-results-%d.txt", Instant.now().getEpochSecond());
        var tmpResultPath = "src/main/resources"+tmpFile;
        assertFalse(new File(tmpResultPath).exists());

        var config = DefaultComponentsProvider.getConfig();
        BenchmarkDataGenerator dataGenerator = new BenchmarkDataGenerator(config);
        BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config);

        List<BenchmarkResultGroup> resultGroups = benchmarkProcessor.getBenchmarkDataReport();
        benchmarkProcessor.setResultsPath(tmpResultPath);
        benchmarkProcessor.saveResults(resultGroups);

        var newReportFile = new File(tmpResultPath);
        assertNotNull(newReportFile);
        assertTrue(newReportFile.delete());
    }
}

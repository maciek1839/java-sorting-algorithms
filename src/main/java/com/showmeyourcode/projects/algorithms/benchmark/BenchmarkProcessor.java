package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import com.showmeyourcode.projects.algorithms.exception.CannotCreateReportResultsFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkProcessor {

    static final Logger logger = LoggerFactory.getLogger(BenchmarkProcessor.class);
    private final BenchmarkDataGenerator dataGenerator;
    private final SortingAppConfiguration appConfiguration;

    public BenchmarkProcessor(BenchmarkDataGenerator dataGenerator, SortingAppConfiguration config) {
        this.dataGenerator = dataGenerator;
        appConfiguration = config;
    }

    public List<BenchmarkResult> getBenchmarkDataReport() {
        final AbstractAlgorithmFactory algorithmFactory = new AlgorithmFactory(appConfiguration);
        List<BenchmarkResult> tmpResults = new ArrayList<>();
        var allAlgorithms = algorithmFactory.creatAllAvailableAlgorithms();
        for (AlgorithmsBenchmarkData benchmarkData : AlgorithmsBenchmarkData.values()) {
            logger.info("Preparing benchmark for {} elements...", benchmarkData.getSize());
            try {
                final int[] initialData = dataGenerator.loadData(benchmarkData);
                for (Algorithm algorithm : allAlgorithms) {
                    logger.debug("Processing {} {}", benchmarkData.getSize(), algorithm.toString());
                    final long memoryAtTheBeginning = getCurrentUsedMemoryInBytes();
                    logger.debug("Memory at the beginning: {}", memoryAtTheBeginning);
                    Long start = System.nanoTime();
                    algorithm.sortData(initialData);
                    Long finish = System.nanoTime();
                    long elapsedNanos = finish - start;
                    final long memoryAtTheEnd = getCurrentUsedMemoryInBytes();
                    logger.debug("Memory at the end: {}", memoryAtTheEnd);
                    tmpResults.add(
                            new BenchmarkResult(
                                    algorithm.getType(),
                                    benchmarkData.getSize(),
                                    elapsedNanos,
                                    memoryAtTheBeginning,
                                    memoryAtTheEnd
                            )
                    );
                }
            } catch (IOException | BenchmarkDataNotFoundException e) {
                logger.error("Cannot load data for benchmark from the path: {}", benchmarkData.getPath(), e);
            }
        }

        return tmpResults;
    }

    private long getCurrentUsedMemoryInBytes() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public void saveResults(List<BenchmarkResult> results) throws CannotCreateReportResultsFileException {
        final String reportResultFilePath = "src/main/resources/benchmark/results.txt";
        File benchmarkResults = new File(reportResultFilePath);

        createResultsFile(benchmarkResults);

        try (OutputStream outStream = new FileOutputStream(benchmarkResults)) {
            final String newLine = "\r\n";
            final String resultAlgorithmEntry = "Dataset size: %d Algorithm: %s Duration: %d Memory: %d/%d Memory difference: %d %s";
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
            final StringBuilder contentBuilder = new StringBuilder();
            Instant instant = Instant.now();
            contentBuilder.append(String.format("--------------- Benchmark results %s---------------%s",
                    formatter.format(instant),
                    newLine
            ));
            for (BenchmarkResult partialResult : results) {
                logger.info(partialResult.toString());
                contentBuilder.append(
                        String.format(
                                resultAlgorithmEntry,
                                partialResult.getDatasetSize(),
                                partialResult.getAlgorithmType(),
                                partialResult.getTimeElapsedInNanoSeconds(),
                                partialResult.getMemoryUsedAtTheBeginningInBytes(),
                                partialResult.getMemoryUsedAtTheEndInBytes(),
                                partialResult.getMemoryRuntimeDifference(),
                                newLine
                        ));
            }

            outStream.write(contentBuilder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Cannot write benchmark results! ", e);
        }
    }

    private void createResultsFile(File benchmarkResults) throws CannotCreateReportResultsFileException {
        try {
            if (benchmarkResults.exists()) {
                logger.debug("The benchmark results file already exists: {}", benchmarkResults.getPath());
            } else {
                benchmarkResults.createNewFile();
                logger.debug("Created the benchmark results file: {}", benchmarkResults.getPath());
            }
        } catch (IOException e) {
            throw new CannotCreateReportResultsFileException(e);
        }
    }
}

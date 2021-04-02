package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
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
import java.util.Optional;

public class BenchmarkProcessor {

    static final Logger logger = LoggerFactory.getLogger(BenchmarkProcessor.class);
    private final BenchmarkDataGenerator dataGenerator;
    private final SortingAppConfiguration appConfiguration;

    public BenchmarkProcessor(BenchmarkDataGenerator dataGenerator, SortingAppConfiguration config) {
        this.dataGenerator = dataGenerator;
        appConfiguration = config;
    }

    public List<BenchmarkResultGroup> getBenchmarkDataReport() {
        final AbstractAlgorithmFactory algorithmFactory = new AlgorithmFactory(appConfiguration);
        List<BenchmarkResultGroup> resultGroups = new ArrayList<>();
        var allAlgorithms = algorithmFactory.creatAllAvailableAlgorithms();
        for (AlgorithmsBenchmarkData benchmarkData : AlgorithmsBenchmarkData.values()) {
            logger.info("Preparing benchmark for {} elements...", benchmarkData.getSize());
            try {
                final int[] initialData = dataGenerator.loadData(benchmarkData);
                BenchmarkResultGroup group = new BenchmarkResultGroup(benchmarkData);
                for (Algorithm algorithm : allAlgorithms) {
                    logger.debug("Processing {} {}", benchmarkData.getSize(), algorithm);
                    final long memoryAtTheBeginning = getCurrentUsedMemoryInBytes();
                    logger.debug("Memory at the beginning: {}", memoryAtTheBeginning);
                    Long start = System.nanoTime();
                    algorithm.sortData(initialData);
                    Long finish = System.nanoTime();
                    long elapsedNanos = finish - start;
                    final long memoryAtTheEnd = getCurrentUsedMemoryInBytes();
                    logger.debug("Memory at the end: {}", memoryAtTheEnd);
                    group.getResults().add(
                            new BenchmarkResult(
                                    algorithm.getType(),
                                    benchmarkData.getSize(),
                                    elapsedNanos,
                                    memoryAtTheBeginning,
                                    memoryAtTheEnd,
                                    algorithm.getMetadata()
                            )
                    );
                }
                resultGroups.add(group);
            } catch (IOException | BenchmarkDataNotFoundException e) {
                logger.error("Cannot load data for benchmark from the path: {}", benchmarkData.getPath(), e);
            }
        }

        return resultGroups;
    }

    private long getCurrentUsedMemoryInBytes() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public void saveResults(List<BenchmarkResultGroup> results) throws CannotCreateReportResultsFileException {
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
            for (BenchmarkResultGroup partialResultGroup : results) {
                logger.info("Processing group: {}", partialResultGroup.getBenchmarkData().getSize());
                for (BenchmarkResult partialResult : partialResultGroup.getResults()) {
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
            }

            logger.info("Preparing the benchmark table in Markdown format...");
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);

            final String benchmarkTableEntry = "| %s |  %d  | %d |  %d |  %s  |  %s  |  %s |  %s |   %s  |  %s  |%s";


            contentBuilder.append("| Algorithm  | 50000&#160;elements&#160;(ns)   | 100000&#160;elements&#160;(ns)    | 150000&#160;elements&#160;(ns)    | Best&#160;complexity   | Average&#160;complexity   | Worst&#160;complexity   | Space&#160;complexity&#160;(the&#160;worst)   | Stable   | In&#160;place  |\n");
            contentBuilder.append("|:--------------------------------|:----------------:|:-----------------:|:-----------------:|:-----------------:|:--------------------:|:------------------:|:------------------------------:|:--------:|:---------:|\n");
            for (AlgorithmType type : AlgorithmType.values()) {
                Optional<BenchmarkResult> elements50k = getBenchmarkResultForDataSize(results, type, 50000);
                Optional<BenchmarkResult> elements100k = getBenchmarkResultForDataSize(results, type, 100000);
                Optional<BenchmarkResult> elements150k = getBenchmarkResultForDataSize(results, type, 150000);
                if (elements50k.isPresent() && elements100k.isPresent() && elements150k.isPresent()) {
                    Algorithm.AlgorithmMetadata metadata = elements50k.get().getMetadata();
                    contentBuilder.append(String.format(
                            benchmarkTableEntry,
                            metadata.getNameInMarkdownFormat(),
                            elements50k.get().getTimeElapsedInNanoSeconds(),
                            elements100k.get().getTimeElapsedInNanoSeconds(),
                            elements150k.get().getTimeElapsedInNanoSeconds(),
                            metadata.getTheBestComplexity(),
                            metadata.getAverageComplexity(),
                            metadata.getWorstComplexity(),
                            metadata.getTheWorstSpaceComplexity(),
                            metadata.getStable(),
                            metadata.getInPlace(),
                            newLine
                    ));
                }
            }

            outStream.write(contentBuilder.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error("Cannot write benchmark results! ", e);
        }
    }

    private void createResultsFile(File benchmarkResults) throws CannotCreateReportResultsFileException {
        try {
            if (benchmarkResults.createNewFile()) {
                logger.debug("The benchmark results file already exists: {}", benchmarkResults.getPath());
            } else {
                logger.debug("Created the benchmark results file: {}", benchmarkResults.getPath());
            }
        } catch (IOException e) {
            throw new CannotCreateReportResultsFileException(e);
        }
    }

    private Optional<BenchmarkResult> getBenchmarkResultForDataSize(List<BenchmarkResultGroup> results,
                                                                    AlgorithmType type,
                                                                    int dataSize) {
        Optional<BenchmarkResultGroup> resultGroup = results.stream()
                .filter(brg -> brg.getBenchmarkData().getSize() == dataSize)
                .findAny();

        if (resultGroup.isEmpty()) {
            return Optional.empty();
        } else {
            return resultGroup.get()
                    .getResults()
                    .stream()
                    .filter(br -> br.getAlgorithmType().equals(type))
                    .findAny();
        }
    }
}

package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import com.showmeyourcode.projects.algorithms.exception.CannotCreateReportResultsFileException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

@Slf4j
@RequiredArgsConstructor
public class BenchmarkProcessor {

    private final BenchmarkDataGenerator dataGenerator;
    private final SortingAppConfiguration appConfiguration;
    private String reportResultFilePath = "src/main/resources/benchmark/%s";

    public BenchmarkReport getBenchmarkDataReport() {
        final AbstractAlgorithmFactory algorithmFactory = new AlgorithmFactory(appConfiguration);
        List<BenchmarkResultGroup> resultGroups = new ArrayList<>();
        var algorithmsToProcess = algorithmFactory.creatAllAvailableAlgorithms();
        var tasks = new ArrayList<BenchmarkGroupTask>();
        long start = System.nanoTime();

        for (AlgorithmsBenchmarkData benchmarkData : AlgorithmsBenchmarkData.values()) {
            if (appConfiguration.datasetSizesForBenchmark().contains(benchmarkData.getSize())) {
                log.info("Preparing benchmark for {} elements...", benchmarkData.getSize());
                try {
                    final int[] unsortedData = dataGenerator.loadData(benchmarkData);

                    var task = new BenchmarkGroupTask(
                            unsortedData,
                            benchmarkData,
                            algorithmsToProcess
                    );
                    task.fork();
                    tasks.add(task);
                } catch (IOException | BenchmarkDataNotFoundException e) {
                    log.error("Cannot load data for benchmark from the path: {}", benchmarkData.getPath(), e);
                }
            } else {
                log.warn("Skipping benchmark for {} elements...", benchmarkData.getSize());
            }
        }

        tasks.forEach(t-> {
                    log.debug("Getting partialResults from: {}", t.getGroupId());
                    resultGroups.add(t.join());
                    log.info("Got partialResults from: {}", t.getGroupId());
        });

        long finish = System.nanoTime();
        long elapsedNanos = finish - start;
        log.info("Benchmarking took: {}ms", ThreadUtil.convertNsToMs(elapsedNanos));

        return new BenchmarkReport(resultGroups);
    }

    public void saveResults(BenchmarkReport report) throws CannotCreateReportResultsFileException {
        var partialResults = report.partialResults();
        File benchmarkResults = new File(String.format(reportResultFilePath,appConfiguration.benchmarkResultsFile()));

        createResultsFile(benchmarkResults);

        try (OutputStream outStream = new FileOutputStream(benchmarkResults)) {
            final String newLine = "\r\n";
            final String resultAlgorithmEntry = "Dataset size: %d Algorithm: %s Duration: %d ns | %d ms%s";
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
            final StringBuilder contentBuilder = new StringBuilder();
            Instant instant = Instant.now();
            contentBuilder.append(String.format("--------------- Benchmark partialResults %s---------------%s",
                    formatter.format(instant),
                    newLine
            ));
            for (BenchmarkResultGroup partialResultGroup : partialResults) {
                log.info("Processing group: {}", partialResultGroup.getBenchmarkData().getSize());
                for (BenchmarkResult partialResult : partialResultGroup.getResults()) {
                    contentBuilder.append(
                            String.format(
                                    resultAlgorithmEntry,
                                    partialResult.datasetSize(),
                                    partialResult.algorithmType(),
                                    partialResult.timeElapsedInNanoSeconds(),
                                    ThreadUtil.convertNsToMs(partialResult.timeElapsedInNanoSeconds()),
                                    newLine
                            ));
                }
            }

            log.info("Preparing the benchmark table in Markdown format...");
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);
            contentBuilder.append(newLine);

            final String benchmarkTableEntry = "| %s |  %d  | %d |  %d |  %s  |  %s  |  %s |  %s |   %s  |  %s  |%s";

            contentBuilder.append("| Algorithm  | 50000&#160;elements&#160;(ms)   | 100000&#160;elements&#160;(ms)    | 150000&#160;elements&#160;(ms)    | Best&#160;complexity   | Average&#160;complexity   | Worst&#160;complexity   | Space&#160;complexity&#160;(the&#160;worst)   | Stable   | In&#160;place  |\n");
            contentBuilder.append("|:--------------------------------|:----------------:|:-----------------:|:-----------------:|:-----------------:|:--------------------:|:------------------:|:------------------------------:|:--------:|:---------:|\n");
            for (AlgorithmType type : AlgorithmType.values()) {
                Optional<BenchmarkResult> elements50k = getBenchmarkResultForDataSize(partialResults, type, 50000);
                Optional<BenchmarkResult> elements100k = getBenchmarkResultForDataSize(partialResults, type, 100000);
                Optional<BenchmarkResult> elements150k = getBenchmarkResultForDataSize(partialResults, type, 150000);
                if (elements50k.isPresent() && elements100k.isPresent() && elements150k.isPresent()) {
                    Algorithm.AlgorithmMetadata metadata = elements50k.get().metadata();
                    contentBuilder.append(String.format(
                            benchmarkTableEntry,
                            metadata.nameInMarkdownFormat(),
                            ThreadUtil.convertNsToMs(elements50k.get().timeElapsedInNanoSeconds()),
                            ThreadUtil.convertNsToMs(elements100k.get().timeElapsedInNanoSeconds()),
                            ThreadUtil.convertNsToMs(elements150k.get().timeElapsedInNanoSeconds()),
                            metadata.theBestComplexity(),
                            metadata.averageComplexity(),
                            metadata.worstComplexity(),
                            metadata.theWorstSpaceComplexity(),
                            metadata.stable(),
                            metadata.inPlace(),
                            newLine
                    ));
                }
            }

            outStream.write(contentBuilder.toString().getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            log.error("Cannot write benchmark partialResults! ", e);
        }
    }

    void setResultsPath(String newPath){
        reportResultFilePath = newPath;
        log.warn("A new path for the result file is set: {}", newPath);
    }

    private void createResultsFile(File benchmarkResults) throws CannotCreateReportResultsFileException {
        try {
            if (benchmarkResults.createNewFile()) {
                log.debug("The benchmark partialResults file already exists: {}", benchmarkResults.getPath());
            } else {
                log.debug("Created the benchmark partialResults file: {}", benchmarkResults.getPath());
            }
        } catch (IOException e) {
            throw new CannotCreateReportResultsFileException(e);
        }
    }

    private Optional<BenchmarkResult> getBenchmarkResultForDataSize(List<BenchmarkResultGroup> results,
                                                                    AlgorithmType type,
                                                                    int dataSize) {
        return results
                .stream()
                .filter(brg -> brg.getBenchmarkData().getSize() == dataSize)
                .findAny()
                .flatMap(e -> e.getResults()
                        .stream()
                        .filter(br -> br.algorithmType().equals(type))
                        .findAny()
                );
    }
}

package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
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
        for (BenchmarkData benchmarkData : BenchmarkData.values()) {
            logger.info("Preparing benchmark for {} elements...", benchmarkData.getSize());
            try {
                final int[] initialData = dataGenerator.loadData(benchmarkData);
                for (Algorithm algorithm : allAlgorithms) {
                    logger.debug("Processing {} {}", benchmarkData.getSize(), algorithm.toString());
                    Instant start = Instant.now();
                    algorithm.sortData(initialData);
                    Instant finish = Instant.now();
                    long timeElapsed = Duration.between(start, finish).toMillis();
                    tmpResults.add(new BenchmarkResult(algorithm.getType(), benchmarkData.getSize(), timeElapsed));
                }
            } catch (IOException e) {
                logger.error("Cannot load data for benchmark from the path: {}", benchmarkData.getPath(), e);
            }
        }

        return tmpResults;
    }

    public void saveResults(List<BenchmarkResult> results) {
        File targetFile = new File("src/main/resources/benchmark/results.txt");
        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
            Instant instant = Instant.now();
            outStream.write((formatter.format(instant) + "\r\n").getBytes(StandardCharsets.UTF_8));
            for (BenchmarkResult partialResult : results) {
                logger.info(partialResult.toString());
                outStream.write((partialResult.toString() + "\r\n").getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            logger.error("Cannot write benchmark results! ", e);
        }
    }
}

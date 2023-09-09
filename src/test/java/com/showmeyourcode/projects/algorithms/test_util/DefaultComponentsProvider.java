package com.showmeyourcode.projects.algorithms.test_util;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputProcessor;
import com.showmeyourcode.projects.algorithms.launcher.SortingAlgorithmsApplication;
import lombok.SneakyThrows;

abstract public class DefaultComponentsProvider {

    private final static int DATA_MAX_RANGE = 10000;
    private final static int DATA_SIZE = 10000;
    private final static int GENERATED_DATASET_SIZE = 150000;

    protected final SortingAppConfigurationLoader configLoader;
    protected final SortingAppConfiguration sortingAppConfiguration;
    protected final BenchmarkDataGenerator benchmarkDataGenerator;
    protected final BenchmarkProcessor benchmarkProcessor;
    protected final AlgorithmFactory algorithmFactory;
    protected final UserInputProcessor userInputProcessor;

    @SneakyThrows
    protected DefaultComponentsProvider() {
        configLoader = new SortingAppConfigurationLoader(SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE);
        sortingAppConfiguration = configLoader.getConfig();
        benchmarkDataGenerator = new BenchmarkDataGenerator(sortingAppConfiguration);
        benchmarkProcessor = new BenchmarkProcessor(benchmarkDataGenerator, sortingAppConfiguration);
        algorithmFactory = new AlgorithmFactory(sortingAppConfiguration);
        userInputProcessor = new UserInputProcessor(
                sortingAppConfiguration,
                benchmarkDataGenerator,
                benchmarkProcessor,
                algorithmFactory
        );
    }

    public static int dataMaxRange() {
        return DATA_MAX_RANGE;
    }

    public static int dataSize() {
        return DATA_SIZE;
    }

    public static SortingAppConfiguration getConfig() {
        return new SortingAppConfiguration(dataSize(), DATA_MAX_RANGE, GENERATED_DATASET_SIZE);
    }

    public static AlgorithmDataGenerator getDataGenerator() {
        return new AlgorithmDataGenerator(getConfig());
    }

    public static BenchmarkDataGenerator getBenchmarkDataGenerator() {
        return new BenchmarkDataGenerator(getConfig());
    }
}

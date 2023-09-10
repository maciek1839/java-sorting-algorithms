package com.showmeyourcode.projects.algorithms.test_util;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputProcessor;
import lombok.SneakyThrows;

abstract public class DefaultComponentsProvider {

    public final static String TEST_PROPERTIES_FILE = "application-test.properties";

    public final static int DATA_MAX_RANGE = 1_000;
    public final static int DATA_SIZE = 1_000;

    public static final SortingAppConfigurationLoader configLoader = configurationLoader();
    public static final SortingAppConfiguration applicationConfiguration = configLoader.getConfiguration();
    public static final AlgorithmDataGenerator algorithmDataGenerator = new AlgorithmDataGenerator(applicationConfiguration);
    public static final BenchmarkDataGenerator benchmarkDataGenerator = new BenchmarkDataGenerator(applicationConfiguration);

    protected final BenchmarkProcessor benchmarkProcessor;
    protected final AlgorithmFactory algorithmFactory;
    protected final UserInputProcessor userInputProcessor;

    @SneakyThrows
    protected DefaultComponentsProvider() {
        benchmarkProcessor = new BenchmarkProcessor(benchmarkDataGenerator, applicationConfiguration);
        algorithmFactory = new AlgorithmFactory(applicationConfiguration);
        userInputProcessor = new UserInputProcessor(
                applicationConfiguration,
                benchmarkDataGenerator,
                benchmarkProcessor,
                algorithmFactory
        );
    }

    @SneakyThrows
    private static SortingAppConfigurationLoader configurationLoader(){
        return new SortingAppConfigurationLoader(TEST_PROPERTIES_FILE);
    }
}

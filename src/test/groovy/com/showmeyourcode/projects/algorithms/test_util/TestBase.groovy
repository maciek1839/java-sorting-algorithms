package com.showmeyourcode.projects.algorithms.test_util

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader
import com.showmeyourcode.projects.algorithms.console.UserInputProcessor
import spock.lang.Specification

abstract class TestBase extends Specification {

    public final static String TEST_PROPERTIES_FILE = "application-test.properties"

    public final static int DATA_MAX_RANGE = 1_000
    public final static int DATA_SIZE = 1_000

    public static final SortingAppConfigurationLoader configLoader = new SortingAppConfigurationLoader(TEST_PROPERTIES_FILE)
    public static final SortingAppConfiguration applicationConfiguration = configLoader.getConfiguration()
    public static final AlgorithmDataGenerator algorithmDataGenerator = new AlgorithmDataGenerator(applicationConfiguration)
    public static final BenchmarkDataGenerator benchmarkDataGenerator = new BenchmarkDataGenerator(applicationConfiguration)

    protected final BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(benchmarkDataGenerator, applicationConfiguration)
    protected final AlgorithmFactory algorithmFactory = new AlgorithmFactory(applicationConfiguration)
    protected final UserInputProcessor userInputProcessor = new UserInputProcessor(
            applicationConfiguration,
            benchmarkDataGenerator,
            benchmarkProcessor,
            algorithmFactory
    )
}

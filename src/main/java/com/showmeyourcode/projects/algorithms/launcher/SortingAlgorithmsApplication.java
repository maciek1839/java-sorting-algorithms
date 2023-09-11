package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputInterceptor;
import com.showmeyourcode.projects.algorithms.console.UserInputProcessor;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
public class SortingAlgorithmsApplication {

    public static final String DEFAULT_PROPERTIES_FILE = "application.properties";
    public static final InputStream DEFAULT_INPUT_STREAM = System.in;

    private final String propertiesFilename;
    private final InputStream inputStream;

    void startApp() throws CannotLoadAppPropertiesException {
        log.info("\nWelcome to The Sorting Algorithms program.");
        final SortingAppConfigurationLoader configLoader = new SortingAppConfigurationLoader(propertiesFilename);
        final SortingAppConfiguration sortingAppConfiguration = configLoader.getConfiguration();
        final BenchmarkDataGenerator benchmarkDataGenerator = new BenchmarkDataGenerator(sortingAppConfiguration);
        final BenchmarkProcessor benchmarkProcessor = new BenchmarkProcessor(benchmarkDataGenerator, sortingAppConfiguration);
        final AlgorithmFactory algorithmFactory = new AlgorithmFactory(sortingAppConfiguration);
        final UserInputProcessor userInputProcessor = new UserInputProcessor(
                sortingAppConfiguration,
                benchmarkDataGenerator,
                benchmarkProcessor,
                algorithmFactory
        );

        final UserInputInterceptor inputInterceptor = new UserInputInterceptor(sortingAppConfiguration, userInputProcessor);
        inputInterceptor.startListening(inputStream);
    }
}

package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputInterceptor;
import com.showmeyourcode.projects.algorithms.console.UserInputProcessor;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class SortingAlgorithmsApplication {

    public static final String DEFAULT_PROPERTIES_FILE = "application.properties";
    public static final InputStream DEFAULT_INPUT_STREAM = System.in;
    static final Logger logger = LoggerFactory.getLogger(SortingAlgorithmsApplication.class);

    private final String propertiesFilename;
    private final InputStream inputStream;

    public SortingAlgorithmsApplication(String propertiesFilename, InputStream inputStream) {
        this.propertiesFilename = propertiesFilename;
        this.inputStream = inputStream;
    }

    void startApp() throws CannotLoadAppPropertiesException {
        final SortingAppConfigurationLoader configLoader = new SortingAppConfigurationLoader(propertiesFilename);
        final SortingAppConfiguration sortingAppConfiguration = configLoader.getConfig();
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

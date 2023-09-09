package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.*;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.exception.CannotCreateReportResultsFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserInputProcessor {

    private static final Logger logger = LoggerFactory.getLogger(UserInputProcessor.class);

    private final SortingAppConfiguration appConfiguration;
    private final BenchmarkProcessor benchmarkProcessor;
    private final BenchmarkDataGenerator benchmarkDataGenerator;
    private final WaitingExecutorService waitingExecutorService;

    private final BubbleSort bubbleSort;
    private final CountingSort countingSort;
    private final HeapSort heapSort;
    private final InsertionSort insertionSort;
    private final MergeSort mergeSort;
    private final QuickSort quickSort;
    private final SelectionSort selectionSort;
    private final CocktailShakerSort cocktailShakerSort;
    private final ShellSort shellSort;
    private Waiting printPoint;

    public UserInputProcessor(SortingAppConfiguration appConfiguration,
                              BenchmarkDataGenerator benchmarkDataGenerator,
                              BenchmarkProcessor benchmarkProcessor,
                              AlgorithmFactory algorithmFactory) {
        waitingExecutorService = new WaitingExecutorService();
        this.appConfiguration = appConfiguration;

        this.benchmarkDataGenerator = benchmarkDataGenerator;//new BenchmarkDataGenerator(config);
        this.benchmarkProcessor = benchmarkProcessor;//new BenchmarkProcessor(benchmarkDataGenerator, config);

        bubbleSort = (BubbleSort) algorithmFactory.createAlgorithm(AlgorithmType.BUBBLE_SORT);
        countingSort = (CountingSort) algorithmFactory.createAlgorithm(AlgorithmType.COUNTING_SORT);
        heapSort = (HeapSort) algorithmFactory.createAlgorithm(AlgorithmType.HEAP_SORT);
        insertionSort = (InsertionSort) algorithmFactory.createAlgorithm(AlgorithmType.INSERTION_SORT);
        mergeSort = (MergeSort) algorithmFactory.createAlgorithm(AlgorithmType.MERGE_SORT);
        quickSort = (QuickSort) algorithmFactory.createAlgorithm(AlgorithmType.QUICK_SORT);
        selectionSort = (SelectionSort) algorithmFactory.createAlgorithm(AlgorithmType.SELECTION_SORT);
        cocktailShakerSort = (CocktailShakerSort) algorithmFactory.createAlgorithm(AlgorithmType.COCKTAIL_SHAKER_SORT);
        shellSort = (ShellSort) algorithmFactory.createAlgorithm(AlgorithmType.SHELL_SORT);
    }

    public void processUserInput(UserMenuChoice userChoice) {
        switch (userChoice) {
            case ALGORITHM_1:
                startAlgorithm(bubbleSort);
                break;
            case ALGORITHM_2:
                startAlgorithm(countingSort);
                break;
            case ALGORITHM_3:
                startAlgorithm(heapSort);
                break;
            case ALGORITHM_4:
                startAlgorithm(insertionSort);
                break;
            case ALGORITHM_5:
                startAlgorithm(mergeSort);
                break;
            case ALGORITHM_6:
                startAlgorithm(quickSort);
                break;
            case ALGORITHM_7:
                startAlgorithm(selectionSort);
                break;
            case ALGORITHM_8:
                startAlgorithm(cocktailShakerSort);
                break;
            case ALGORITHM_9:
                startAlgorithm(shellSort);
                break;
            case BENCHMARK:
                printPoint = new Waiting();
                startWaiting();
                var benchMarkReport = benchmarkProcessor.getBenchmarkDataReport();
                try {
                    benchmarkProcessor.saveResults(benchMarkReport);
                } catch (CannotCreateReportResultsFileException e) {
                    logger.error("Cannot save benchmark results. ", e);
                }
                stopWaiting();
                break;
            case GENERATE_DATASET:
                generateNewDataset();
                break;
            case EXIT:
                logger.info("Thank you and see you again!");
                break;
            case BAD_USER_INPUT:
                break;
        }
    }

    private void startAlgorithm(Algorithm algorithm) {
        printPoint = new Waiting();
        startWaiting();
        runAlgorithm(algorithm);
        stopWaiting();
    }

    void generateNewDataset() {
        try {
            benchmarkDataGenerator.generateNewDataset(appConfiguration.defaultGeneratedDatasetSize());
        } catch (IOException e) {
            logger.error("Cannot generate a new dataset. ", e);
        }
    }

    void runAlgorithm(Algorithm algorithm) {
        logger.info("Name: {} Time: {} s", algorithm, algorithm.showUsage());
        logger.info("Number of elements: {} Max element value: {}",
                appConfiguration.dataSize(),
                appConfiguration.maxRange());
    }

    void startWaiting() {
        waitingExecutorService.execute(printPoint);
    }

    void stopWaiting() {
        printPoint.setDone();
    }
}

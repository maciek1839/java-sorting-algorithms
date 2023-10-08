package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.BubbleSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.CocktailShakerSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.CountingSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.HeapSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.InsertionSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.MergeSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.QuickSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.SelectionSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.ShellSort;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.exception.CannotCreateReportResultsFileException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class UserInputProcessor {

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
    private WaitingRunnable printPoint;

    public UserInputProcessor(SortingAppConfiguration appConfiguration,
                              BenchmarkDataGenerator benchmarkDataGenerator,
                              BenchmarkProcessor benchmarkProcessor,
                              AlgorithmFactory algorithmFactory) {
        waitingExecutorService = new WaitingExecutorService();
        this.appConfiguration = appConfiguration;

        this.benchmarkDataGenerator = benchmarkDataGenerator;
        this.benchmarkProcessor = benchmarkProcessor;

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
                printPoint = new WaitingRunnable();
                startWaiting();
                var report = benchmarkProcessor.getBenchmarkDataReport();
                try {
                    benchmarkProcessor.saveResults(report);
                } catch (CannotCreateReportResultsFileException e) {
                    log.error("Cannot save benchmark partialResults. ", e);
                }
                stopWaiting();
                break;
            case GENERATE_DATASET:
                generateNewDataset();
                break;
            case EXIT:
                log.info("Thank you and see you again!");
                break;
            case BAD_USER_INPUT:
                break;
        }
    }

    private void startAlgorithm(Algorithm algorithm) {
        printPoint = new WaitingRunnable();
        startWaiting();
        runAlgorithm(algorithm);
        stopWaiting();
    }

    void generateNewDataset() {
        try {
            benchmarkDataGenerator.generateNewDataset(appConfiguration.defaultGeneratedDatasetSize());
        } catch (IOException e) {
            log.error("Cannot generate a new dataset. ", e);
        }
    }

    void runAlgorithm(Algorithm algorithm) {
        log.info("Name: {} Time: {} s", algorithm, algorithm.showUsage());
        log.info("Number of elements: {} Max element value: {}",
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

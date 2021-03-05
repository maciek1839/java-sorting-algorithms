package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.algorithm.AbstractAlgorithmFactory;
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.*;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInputProcessor {

    private static final Logger logger = LoggerFactory.getLogger(UserInputProcessor.class);

    private final SortingAppConfiguration appConfiguration;
    private final BenchmarkProcessor benchmarkProcessor;

    private final BubbleSort bubbleSort;
    private final CountingSort countingSort;
    private final HeapSort heapSort;
    private final InsertSort insertSort;
    private final MergeSort mergeSort;
    private final QuickSort quickSort;
    private final SelectionSort selectionSort;
    private final ShakerSort shakerSort;
    private final ShellSort shellSort;
    private Waiting printPoint = new Waiting();

    public UserInputProcessor(SortingAppConfiguration config) {
        appConfiguration = config;
        benchmarkProcessor = new BenchmarkProcessor(new BenchmarkDataGenerator(config), config);
        final AbstractAlgorithmFactory algorithmFactory = new AlgorithmFactory(config);
        bubbleSort = (BubbleSort) algorithmFactory.createAlgorithm(AlgorithmType.BUBBLE_SORT);
        countingSort = (CountingSort) algorithmFactory.createAlgorithm(AlgorithmType.COUNTING_SORT);
        heapSort = (HeapSort) algorithmFactory.createAlgorithm(AlgorithmType.HEAP_SORT);
        insertSort = (InsertSort) algorithmFactory.createAlgorithm(AlgorithmType.INSERT_SORT);
        mergeSort = (MergeSort) algorithmFactory.createAlgorithm(AlgorithmType.MERGE_SORT);
        quickSort = (QuickSort) algorithmFactory.createAlgorithm(AlgorithmType.QUICK_SORT);
        selectionSort = (SelectionSort) algorithmFactory.createAlgorithm(AlgorithmType.SELECTION_SORT);
        shakerSort = (ShakerSort) algorithmFactory.createAlgorithm(AlgorithmType.SHAKER_SORT);
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
                startAlgorithm(insertSort);
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
                startAlgorithm(shakerSort);
                break;
            case ALGORITHM_9:
                startAlgorithm(shellSort);
                break;
            case BENCHMARK:
                printPoint = new Waiting();
                startWaiting();
                var benchMarkReport = benchmarkProcessor.getBenchmarkDataReport();
                benchmarkProcessor.saveResults(benchMarkReport);
                stopWaiting();
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

    void runAlgorithm(Algorithm algorithm) {
        logger.info("Name: {} Time: {} s", algorithm, algorithm.showUsage());
        logger.info("Number of elements: {} Max element value: {}",
                appConfiguration.getDataSize(),
                appConfiguration.getMaxRange());
    }

    void startWaiting() {
        printPoint.start();
    }

    void stopWaiting() {
        printPoint.setDone();
    }
}

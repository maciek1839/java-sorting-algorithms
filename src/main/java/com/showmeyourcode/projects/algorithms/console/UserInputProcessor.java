package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.algorithm.*;
import com.showmeyourcode.projects.algorithms.constant.UserMenuChoice;
import com.showmeyourcode.projects.algorithms.factory.AlgorithmFactory;
import com.showmeyourcode.projects.algorithms.factory.AlgorithmFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInputProcessor {

    private static final Logger logger = LoggerFactory.getLogger(UserInputProcessor.class);

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

    public UserInputProcessor() {
        final AlgorithmFactory algorithmFactory = new AlgorithmFactoryImpl();
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

    private void runAlgorithm(Algorithm algorithm) {
        logger.info("\nName: {} Time: {} s", algorithm, algorithm.showUsage());
        logger.info("Number of elements: {}    Ranging from -{} to {}", Algorithm.DATASET_SIZE, Algorithm.DATASET_MAX_RANGE - 1, Algorithm.DATASET_MAX_RANGE - 1);
    }

    private void startWaiting() {
        printPoint.start();
    }

    private void stopWaiting() {
        printPoint.setDone();
    }

    void processUserInput(UserMenuChoice userChoice) {
        switch (userChoice) {
            case ALGORITHM_1:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(bubbleSort);
                stopWaiting();
                break;
            case ALGORITHM_2:
                startWaiting();
                runAlgorithm(countingSort);
                stopWaiting();
                break;
            case ALGORITHM_3:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(heapSort);
                stopWaiting();
                break;
            case ALGORITHM_4:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(insertSort);
                stopWaiting();
                break;
            case ALGORITHM_5:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(mergeSort);
                stopWaiting();
                break;
            case ALGORITHM_6:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(quickSort);
                stopWaiting();
                break;
            case ALGORITHM_7:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(selectionSort);
                stopWaiting();
                break;
            case ALGORITHM_8:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(shakerSort);
                stopWaiting();
                break;
            case ALGORITHM_9:
                printPoint = new Waiting();
                startWaiting();
                runAlgorithm(shellSort);
                stopWaiting();
                break;
            case EXIT:
                logger.info("Thank you and see you again!");
                break;
            default:
                logger.warn("Bad value, try again!\n");
        }
    }
}

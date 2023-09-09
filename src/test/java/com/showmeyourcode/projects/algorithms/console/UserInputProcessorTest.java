package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.*;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class UserInputProcessorTest extends DefaultComponentsProvider {

    private UserInputProcessor classUnderTest;

    public static Stream<Arguments> getAvailableUserChoices() {
        return Stream.of(
                Arguments.of(UserMenuChoice.ALGORITHM_1, BubbleSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_2, CountingSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_3, HeapSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_4, InsertionSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_5, MergeSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_6, QuickSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_7, SelectionSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_8, CocktailShakerSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_9, ShellSort.class)
        );
    }

    @BeforeEach
    void setup() {
        classUnderTest = Mockito.spy(
                new UserInputProcessor(
              sortingAppConfiguration,
              benchmarkDataGenerator,
              benchmarkProcessor,
              algorithmFactory
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getAvailableUserChoices")
    void should_runAlgorithm_when_properDigitIsChosen(UserMenuChoice userChoice, Class<Algorithm> type) {
        classUnderTest.processUserInput(userChoice);
        verify(classUnderTest, times(1)).runAlgorithm(isA(type));
        verify(classUnderTest, times(1)).startWaiting();
        verify(classUnderTest, times(1)).stopWaiting();
    }

    @Test
    void should_generateNewDataset_when_properDigitIsChosenAndDatasetDoesNotExist() {
        int newDatasetSize = 1234;
        UserInputProcessor userInputProcessor = Mockito.spy(new UserInputProcessor(
                new SortingAppConfiguration(100, 2000, newDatasetSize),
                benchmarkDataGenerator,
                benchmarkProcessor,
                algorithmFactory
        ));
        assertFalse(benchmarkDataGenerator.isDatasetAvailable(newDatasetSize));

        userInputProcessor.processUserInput(UserMenuChoice.GENERATE_DATASET);
        verify(userInputProcessor, times(1)).generateNewDataset();
        verify(userInputProcessor, never()).runAlgorithm(any());
        verify(userInputProcessor, never()).startWaiting();
        verify(userInputProcessor, never()).stopWaiting();

        assertTrue(benchmarkDataGenerator.isDatasetAvailable(newDatasetSize));
        assertTrue(benchmarkDataGenerator.deleteDataset(newDatasetSize));
        assertFalse(benchmarkDataGenerator.isDatasetAvailable(newDatasetSize));
    }


    @Test
    void should_failToGenerateNewDataset_when_datasetAlreadyExists() {
        classUnderTest.processUserInput(UserMenuChoice.GENERATE_DATASET);
        verify(classUnderTest, times(1)).generateNewDataset();
        verify(classUnderTest, never()).runAlgorithm(any());
        verify(classUnderTest, never()).startWaiting();
        verify(classUnderTest, never()).stopWaiting();
    }

    @Test
    void should_exit_when_properDigitIsChosen() {
        classUnderTest.processUserInput(UserMenuChoice.EXIT);
        verify(classUnderTest, never()).runAlgorithm(any());
        verify(classUnderTest, never()).startWaiting();
        verify(classUnderTest, never()).stopWaiting();
    }
}

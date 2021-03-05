package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.*;
import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class UserInputProcessorTest {

    private UserInputProcessor classUnderTest;

    public static Stream<Arguments> getAvailableUserChoices() {
        return Stream.of(
                Arguments.of(UserMenuChoice.ALGORITHM_1, BubbleSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_2, CountingSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_3, HeapSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_4, InsertSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_5, MergeSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_6, QuickSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_7, SelectionSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_8, ShakerSort.class),
                Arguments.of(UserMenuChoice.ALGORITHM_9, ShellSort.class)
        );
    }

    @BeforeEach
    void setup() {
        classUnderTest = Mockito.spy(new UserInputProcessor(StaticValueProvider.getConfig()));
    }

    @ParameterizedTest
    @MethodSource("getAvailableUserChoices")
    void should_runAlgorithm_when_properDigitIsChosen(UserMenuChoice userChoice, Class<Algorithm> type) {
        classUnderTest.processUserInput(userChoice);
        verify(classUnderTest, times(1)).runAlgorithm(isA(type));
        verify(classUnderTest, times(1)).startWaiting();
        verify(classUnderTest, times(1)).stopWaiting();
    }
}

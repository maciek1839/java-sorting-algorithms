package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserInputInterceptorTest extends DefaultComponentsProvider {

    private UserInputInterceptor classUnderTest;

    public static Stream<Arguments> getExampleUserBadInput() {
        return Stream.of(
                Arguments.of("asd11"),
                Arguments.of(" asdd as  sda 11"),
                Arguments.of("1s"),
                Arguments.of("1  1"),
                Arguments.of("1  1  1  1"),
                Arguments.of(String.valueOf(UserMenuChoice.getHighestAvailableUserChoice() + 1))
        );
    }

    public static Stream<Arguments> getExampleUserInput() {
        return Stream.of(
                Arguments.of(String.valueOf(UserMenuChoice.EXIT.getUserChoice()), UserMenuChoice.EXIT),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_1.getUserChoice()), UserMenuChoice.ALGORITHM_1),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_2.getUserChoice()), UserMenuChoice.ALGORITHM_2),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_3.getUserChoice()), UserMenuChoice.ALGORITHM_3),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_4.getUserChoice()), UserMenuChoice.ALGORITHM_4),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_5.getUserChoice()), UserMenuChoice.ALGORITHM_5),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_6.getUserChoice()), UserMenuChoice.ALGORITHM_6),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_7.getUserChoice()), UserMenuChoice.ALGORITHM_7),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_8.getUserChoice()), UserMenuChoice.ALGORITHM_8),
                Arguments.of(String.valueOf(UserMenuChoice.ALGORITHM_9.getUserChoice()), UserMenuChoice.ALGORITHM_9),
                Arguments.of(String.valueOf(UserMenuChoice.BENCHMARK.getUserChoice()), UserMenuChoice.BENCHMARK),
                Arguments.of(String.valueOf(UserMenuChoice.GENERATE_DATASET.getUserChoice()), UserMenuChoice.GENERATE_DATASET)
        );
    }

    @BeforeEach
    void setup() {
        classUnderTest = new UserInputInterceptor(
                sortingAppConfiguration,
                userInputProcessor
        );
    }

    @ParameterizedTest
    @MethodSource("getExampleUserInput")
    void should_properlyParseOption_when_inputIsKnown(String userInput, UserMenuChoice userMenuChoice) {
        Optional<UserMenuChoice> result = classUnderTest.userChoice(userInput);
        assertTrue(result.isPresent());
        assertEquals(userMenuChoice, result.get());
    }

    @ParameterizedTest
    @MethodSource("getExampleUserBadInput")
    void should_detectBadInput_when_inputIsCharacters(String userInput) {
        Optional<UserMenuChoice> result = classUnderTest.userChoice(userInput);
        assertTrue(result.isPresent());
        assertEquals(UserMenuChoice.BAD_USER_INPUT, result.get());
    }
}

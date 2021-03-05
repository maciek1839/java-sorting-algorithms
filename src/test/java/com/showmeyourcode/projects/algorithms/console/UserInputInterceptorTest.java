package com.showmeyourcode.projects.algorithms.console;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserInputInterceptorTest {

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
                Arguments.of("11", UserMenuChoice.EXIT),
                Arguments.of("1", UserMenuChoice.ALGORITHM_1),
                Arguments.of("2", UserMenuChoice.ALGORITHM_2),
                Arguments.of("3", UserMenuChoice.ALGORITHM_3),
                Arguments.of("4", UserMenuChoice.ALGORITHM_4),
                Arguments.of("5", UserMenuChoice.ALGORITHM_5),
                Arguments.of("6", UserMenuChoice.ALGORITHM_6),
                Arguments.of("7", UserMenuChoice.ALGORITHM_7),
                Arguments.of("8", UserMenuChoice.ALGORITHM_8),
                Arguments.of("9", UserMenuChoice.ALGORITHM_9),
                Arguments.of("10", UserMenuChoice.BENCHMARK)
        );
    }

    @BeforeEach
    void setup() {
        classUnderTest = new UserInputInterceptor(StaticValueProvider.getConfig());
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

    @Test
    @Disabled
    void should_notPrintAnything_when_inputIsBad() {

    }

}

package com.showmeyourcode.projects.algorithms.console

import com.showmeyourcode.projects.algorithms.test_util.TestBase

class UserInputInterceptorTest extends TestBase {

    def "should properly parse an options when input is known"() {
        given:
        def userInputInterceptor = new UserInputInterceptor(
                applicationConfiguration,
                userInputProcessor
        )

        when:
        def result = userInputInterceptor.userChoice(userInput)

        then:
        result.isPresent()
        and:
        userMenuChoice == result.get()

        where:
        userInput                                                       | userMenuChoice
        String.valueOf(UserMenuChoice.EXIT.getUserChoice())             | UserMenuChoice.EXIT
        String.valueOf(UserMenuChoice.ALGORITHM_1.getUserChoice())      | UserMenuChoice.ALGORITHM_1
        String.valueOf(UserMenuChoice.ALGORITHM_2.getUserChoice())      | UserMenuChoice.ALGORITHM_2
        String.valueOf(UserMenuChoice.ALGORITHM_3.getUserChoice())      | UserMenuChoice.ALGORITHM_3
        String.valueOf(UserMenuChoice.ALGORITHM_4.getUserChoice())      | UserMenuChoice.ALGORITHM_4
        String.valueOf(UserMenuChoice.ALGORITHM_5.getUserChoice())      | UserMenuChoice.ALGORITHM_5
        String.valueOf(UserMenuChoice.ALGORITHM_6.getUserChoice())      | UserMenuChoice.ALGORITHM_6
        String.valueOf(UserMenuChoice.ALGORITHM_7.getUserChoice())      | UserMenuChoice.ALGORITHM_7
        String.valueOf(UserMenuChoice.ALGORITHM_8.getUserChoice())      | UserMenuChoice.ALGORITHM_8
        String.valueOf(UserMenuChoice.ALGORITHM_9.getUserChoice())      | UserMenuChoice.ALGORITHM_9
        String.valueOf(UserMenuChoice.BENCHMARK.getUserChoice())        | UserMenuChoice.BENCHMARK
        String.valueOf(UserMenuChoice.GENERATE_DATASET.getUserChoice()) | UserMenuChoice.GENERATE_DATASET
    }

    def "should detect bad input when input is non-digit character"() {
        given:
        def userInputInterceptor = new UserInputInterceptor(
                applicationConfiguration,
                userInputProcessor
        )
        when:
        def result = userInputInterceptor.userChoice(userInput)

        then:
        result.isPresent()
        and:
        UserMenuChoice.BAD_USER_INPUT == result.get()

        where:
        userInput << [
                "asd11",
                " asdd as  sda 11",
                "1s",
                "1  1",
                "1  1  1  1",
                String.valueOf(UserMenuChoice.getHighestAvailableUserChoice() + 1),
        ]
    }
}

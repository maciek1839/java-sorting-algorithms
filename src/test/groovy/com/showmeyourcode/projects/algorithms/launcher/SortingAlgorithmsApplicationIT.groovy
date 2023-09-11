package com.showmeyourcode.projects.algorithms.launcher

import com.showmeyourcode.projects.algorithms.algorithm.implementation.BubbleSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.CocktailShakerSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.CountingSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.HeapSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.InsertionSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.MergeSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.QuickSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.SelectionSort
import com.showmeyourcode.projects.algorithms.algorithm.implementation.ShellSort
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkProcessor
import com.showmeyourcode.projects.algorithms.console.UserInputProcessor
import com.showmeyourcode.projects.algorithms.console.UserMenuChoice
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException
import com.showmeyourcode.projects.algorithms.test_util.TestBase
import nl.altindag.log.LogCaptor

import java.nio.charset.StandardCharsets

class SortingAlgorithmsApplicationIT extends TestBase {

    def "should fail when cannot load application properties"() {
        given:
        def application = new SortingAlgorithmsApplication(
                "bad-file.properties",
                SortingAlgorithmsApplication.DEFAULT_INPUT_STREAM
        )

        when:
        application.startApp()

        then:
        thrown(CannotLoadAppPropertiesException)
    }

    def "should exit when the exit option is pressed"() {
        given:
        def logCaptor = LogCaptor.forClass(UserInputProcessor.class)
        def exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice())
        def testInputStream = new ByteArrayInputStream(exitOption.getBytes())
        def application = new SortingAlgorithmsApplication(
                TEST_PROPERTIES_FILE,
                testInputStream
        )

        when:
        application.startApp()

        then:
        logCaptor.getLogs().size() == 1
        and:
        logCaptor.getLogs().get(0) == "Thank you and see you again!"
    }

    def "should ignore bad input when non digits are pressed"() {
        given:
        def logCaptor = LogCaptor.forClass(UserInputProcessor.class)
        def exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice())
        def testInputStream = new ByteArrayInputStream(
                String.format("%s\n%s\n", "abc", exitOption).getBytes(StandardCharsets.UTF_8)
        )
        def application = new SortingAlgorithmsApplication(
                TEST_PROPERTIES_FILE,
                testInputStream
        )

        when:
        application.startApp()

        then:
        logCaptor.getLogs().size() == 1
        and:
        logCaptor.getLogs().get(0) == "Thank you and see you again!"
    }


    def "should do sorting when al algorithm option is chosen"() {
        given:
        def logCaptor = LogCaptor.forClass(UserInputProcessor.class)
        def option1 = String.valueOf(userChoiceMenu.getUserChoice())
        def exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice())
        def testInputStream = new ByteArrayInputStream(
                String.format("%s\n%s\n", option1, exitOption).getBytes(StandardCharsets.UTF_8)
        )
        def application = new SortingAlgorithmsApplication(
                TEST_PROPERTIES_FILE,
                testInputStream
        )

        when:
        application.startApp()

        then:
        logCaptor.getLogs().size() == 3
        logCaptor.getLogs().get(0) == "Name: ${algorithm.toString()} Time: 0 s"
        logCaptor.getLogs().get(1) == "Number of elements: 1000 Max element value: 1000"
        logCaptor.getLogs().get(2) == "Thank you and see you again!"

        where:
        userChoiceMenu             | algorithm
        UserMenuChoice.ALGORITHM_1 | new BubbleSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_2 | new CountingSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_3 | new HeapSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_4 | new InsertionSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_5 | new MergeSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_6 | new QuickSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_7 | new SelectionSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_8 | new CocktailShakerSort(algorithmDataGenerator)
        UserMenuChoice.ALGORITHM_9 | new ShellSort(algorithmDataGenerator)
    }


    def "should do benchmark when the option is chosen"() {
        given:
        def logCaptor = LogCaptor.forClass(BenchmarkProcessor.class)

        def option1 = String.valueOf(UserMenuChoice.BENCHMARK.getUserChoice())
        def exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice())
        def testInputStream = new ByteArrayInputStream(
                String.format("%s\n%s\n", option1, exitOption).getBytes(StandardCharsets.UTF_8)
        )
        def application = new SortingAlgorithmsApplication(
                TEST_PROPERTIES_FILE,
                testInputStream
        )

        when:
        application.startApp()

        then:
        logCaptor.getLogs().contains("Preparing the benchmark table in Markdown format...")
    }
}

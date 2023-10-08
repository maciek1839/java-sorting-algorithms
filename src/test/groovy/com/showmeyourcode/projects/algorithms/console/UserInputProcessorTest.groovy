package com.showmeyourcode.projects.algorithms.console

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration
import com.showmeyourcode.projects.algorithms.test_util.TestBase
import spock.lang.Ignore

class UserInputProcessorTest extends TestBase {

    def "should generate a new dataset when a proper option is chosen and the dataset does not exist"() {
        given:
        def newDatasetSize = 1234
        def testInputProcessor = new UserInputProcessor(
                new SortingAppConfiguration(100, 2000, newDatasetSize, "tmp-file.txt", Collections.emptyList()),
                benchmarkDataGenerator,
                benchmarkProcessor,
                algorithmFactory
        )

        assert !benchmarkDataGenerator.isDatasetAvailable(newDatasetSize)

        when:
        testInputProcessor.processUserInput(UserMenuChoice.GENERATE_DATASET)

        then:
        benchmarkDataGenerator.isDatasetAvailable(newDatasetSize)
        and:
        benchmarkDataGenerator.deleteDataset(newDatasetSize)
        and:
        !benchmarkDataGenerator.isDatasetAvailable(newDatasetSize)
    }

    @Ignore("Errors from Spock library: Cannot create mock for class com.showmeyourcode.projects.algorithms.console.UserInputProcessor. To solve this problem, put an up-to-date version of Objenesis on the class path (recommended), or supply constructor arguments (e.g. 'constructorArgs: [42]') that allow to construct an object of the mocked type.")
    def "should fail to generate a new dataset when the dataset already exists"() {
        given:
        def userInputProcessor = Spy(new UserInputProcessor(
                applicationConfiguration,
                benchmarkDataGenerator,
                benchmarkProcessor,
                algorithmFactory
        ))
        when:
        userInputProcessor.processUserInput(UserMenuChoice.GENERATE_DATASET)

        then:
        1 * userInputProcessor.generateNewDataset()
        and:
        0 * userInputProcessor.runAlgorithm(_)
        and:
        0 * userInputProcessor.startWaiting()
        and:
        0 * userInputProcessor.stopWaiting()
    }
}

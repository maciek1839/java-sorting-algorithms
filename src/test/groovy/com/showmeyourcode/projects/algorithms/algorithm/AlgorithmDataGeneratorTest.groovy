package com.showmeyourcode.projects.algorithms.algorithm

import com.showmeyourcode.projects.algorithms.test_util.TestBase
import groovy.util.logging.Slf4j

@Slf4j
class AlgorithmDataGeneratorTest extends TestBase {


    def "should generate sorting data when size is known"() {
        given:
        def generator = new AlgorithmDataGenerator(applicationConfiguration)

        when:
        def generatedData = generator.generateIntData()

        then:
        generatedData.length == DATA_SIZE
        def highestValue = getHighestArrayValue(generatedData)
        highestValue <= DATA_MAX_RANGE

        log.debug("The highest value is: {}", highestValue)
    }

    private int getHighestArrayValue(int[] array) {
        return Arrays.stream(array).reduce(0, (total, elem) -> Math.max(total, elem))
    }
}

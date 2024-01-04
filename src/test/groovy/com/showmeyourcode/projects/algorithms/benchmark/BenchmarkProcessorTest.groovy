package com.showmeyourcode.projects.algorithms.benchmark

import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException
import com.showmeyourcode.projects.algorithms.test_util.TestBase

class BenchmarkProcessorTest extends TestBase {

    def "should generate a report for algorithms without errors when the rest throw exceptions"() {
        given:
        def dataGenerator = Mock(BenchmarkDataGenerator.class)
        dataGenerator.loadData(_ as BenchmarkData) >> { BenchmarkData data ->
            if (data == AlgorithmsBenchmarkData.FIFTY_THOUSAND) {
                return new int[]{5, 32, 4, 21, 7}
            } else {
                throw new BenchmarkDataNotFoundException(data)
            }
        }
        def benchmarkProcessor = new BenchmarkProcessor(dataGenerator, applicationConfiguration)

        when:
        def report = benchmarkProcessor.getBenchmarkDataReport()

        then:
        report.partialResults().size() == 1
        and:
        report.partialResults().stream().mapToInt(group -> group.results.size()).sum() == 9
    }
}

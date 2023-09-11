package com.showmeyourcode.projects.algorithms.benchmark


import com.showmeyourcode.projects.algorithms.test_util.TestBase

import java.time.Instant

class BenchmarkProcessorIT extends TestBase {

    def "should generate a report for all defined algorithms when no errors"() {
        given:
        def config = applicationConfiguration
        def dataGenerator = new BenchmarkDataGenerator(config)
        def benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config)

        when:
        def report = benchmarkProcessor.getBenchmarkDataReport()

        then:
        report.partialResults().size() == 2
        report.partialResults().stream().mapToInt(group -> group.results.size()).sum() == 18
    }

    def "should save a report result when results are available"() {
        given:
        def tmpFile = "/benchmark/test-partialResults-${Instant.now().getEpochSecond()}.txt"
        def tmpResultPath = "src/main/resources/${tmpFile}"

        assert !new File(tmpResultPath).exists()

        def config = applicationConfiguration
        def dataGenerator = new BenchmarkDataGenerator(config)
        def benchmarkProcessor = new BenchmarkProcessor(dataGenerator, config)

        when:
        def resultGroups = benchmarkProcessor.getBenchmarkDataReport()
        benchmarkProcessor.setResultsPath(tmpResultPath)
        benchmarkProcessor.saveResults(resultGroups)

        then:
        def tmpResultReportPath = new File(tmpResultPath)
        tmpResultReportPath.exists()
        tmpResultReportPath.delete()
    }
}

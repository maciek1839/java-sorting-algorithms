package com.showmeyourcode.projects.algorithms.benchmark

import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException
import com.showmeyourcode.projects.algorithms.test_util.TestBase

class AlgorithmsBenchmarkDataGeneratorTest extends TestBase {

    def "should load benchmark data when a file exists"() {
        given:
        def benchmarkDataGenerator = new BenchmarkDataGenerator(applicationConfiguration)

        when:
        def loadedData = benchmarkDataGenerator.loadData(
                AlgorithmsBenchmarkData.FIFTY_THOUSAND
        )

        then:
        loadedData.length == 50_000
    }

    def "should fail loading data when a file does not exist"() {
        given:
        def benchmarkDataGenerator = new BenchmarkDataGenerator(applicationConfiguration)

        when:
        benchmarkDataGenerator.loadData(TestBenchmarkData.BROKEN_BENCHMARK_DATA)

        then:
        thrown(BenchmarkDataNotFoundException)
    }
}

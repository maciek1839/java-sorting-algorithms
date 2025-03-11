package com.showmeyourcode.projects.algorithms.algorithm.implementation

import com.showmeyourcode.projects.algorithms.benchmark.AlgorithmsBenchmarkData
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkGroupTask
import com.showmeyourcode.projects.algorithms.benchmark.ThreadUtil

class MergeSort2Test extends AlgorithmTestBase {

    def setProperAlgorithm() {
        this.algorithm = new MergeSort2(algorithmDataGenerator)
    }

    // This test will ensure that the implementation is correct.
    def "should have O(n log n) complexity"() {
        given:
        def unsortedData = benchmarkDataGenerator.loadData(AlgorithmsBenchmarkData.ONE_HUNDRED_FIFTY_THOUSAND)
        def benchmarkTask = new BenchmarkGroupTask(unsortedData, AlgorithmsBenchmarkData.ONE_HUNDRED_FIFTY_THOUSAND, List.of(this.algorithm))
        when:
        def benchmarkResult = benchmarkTask.invoke()

        then:
        ThreadUtil.convertNsToMs(benchmarkResult.results.get(0).timeElapsedInNanoSeconds()) < 200
    }
}

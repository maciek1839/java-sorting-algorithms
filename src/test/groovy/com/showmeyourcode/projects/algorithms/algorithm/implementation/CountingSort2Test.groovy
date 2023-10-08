package com.showmeyourcode.projects.algorithms.algorithm.implementation

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm
import com.showmeyourcode.projects.algorithms.benchmark.AlgorithmsBenchmarkData
import com.showmeyourcode.projects.algorithms.benchmark.TestBenchmarkData
import com.showmeyourcode.projects.algorithms.test_util.TestBase

class CountingSort2Test extends TestBase {

    private Algorithm algorithm = new CountingSort2(algorithmDataGenerator)

    def "should properly sort data when input is non-negative"() {
        when:
        def sortedData = algorithm.sortData(randomOrderData)

        then:
        expectedData == sortedData

        where:
        randomOrderData                                                         | expectedData
        new int[0]                                                              | new int[]{}
        new int[]{5, 4, 3, 2, 1, 0}                                             | new int[]{0, 1, 2, 3, 4, 5}
        new int[]{4, 6, 2, 4, 3, 1}                                             | new int[]{1, 2, 3, 4, 4, 6}
        new int[]{1, 2, 3, 4, 4, 5}                                             | new int[]{1, 2, 3, 4, 4, 5}
        new int[]{5, 5, 5, 5, 5, 5, 1, 5, 5, 5}                                 | new int[]{1, 5, 5, 5, 5, 5, 5, 5, 5, 5}
        new int[]{4, 77, 5, 4, 33, 5, 7, 8, 9, 9, 9, 96, 5, 54, 33, 55, 3, 2}   | new int[]{2, 3, 4, 4, 5, 5, 5, 7, 8, 9, 9, 9, 33, 33, 54, 55, 77, 96}
        benchmarkDataGenerator.loadData(AlgorithmsBenchmarkData.FIFTY_THOUSAND) | benchmarkDataGenerator.loadData(TestBenchmarkData.SORTED_50K_BENCHMARK_DATA)
    }
}

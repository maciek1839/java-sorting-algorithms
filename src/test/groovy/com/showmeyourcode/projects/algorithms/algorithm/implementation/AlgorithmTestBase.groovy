package com.showmeyourcode.projects.algorithms.algorithm.implementation

import com.github.javafaker.Faker
import com.showmeyourcode.projects.algorithms.algorithm.Algorithm
import com.showmeyourcode.projects.algorithms.benchmark.AlgorithmsBenchmarkData
import com.showmeyourcode.projects.algorithms.benchmark.TestBenchmarkData
import com.showmeyourcode.projects.algorithms.test_util.TestBase
import groovy.util.logging.Slf4j
import spock.lang.Shared

@Slf4j
abstract class AlgorithmTestBase extends TestBase {

    protected Algorithm algorithm
    @Shared
    private Faker faker = new Faker()
    @Shared
    private int[] random200
    @Shared
    private int[] random500
    @Shared
    private int[] random1200
    @Shared
    private int[] random2000

    abstract def setProperAlgorithm();

    def setupSpec() {
        faker = new Faker()
        random200 = getRandomIntArray(200)
        random500 = getRandomIntArray(500)
        random1200 = getRandomIntArray(1200)
        random2000 = getRandomIntArray(2000)
    }

    def setup() {
        setProperAlgorithm()
        log.debug("The test class set: ${algorithm.getClass()}")
    }

    def "should return an empty array when data is invalid"() {
        when:
        def sortedData = algorithm.sortData(null)

        then:
        sortedData.length == 0
    }

    def "should properly sort data when input is valid"() {
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
        new int[]{22, 6, 7, 4, 3, 6, 1}                                         | new int[]{1, 3, 4, 6, 6, 7, 22}
        new int[]{-1, 2, 3, 4, -4, 5, 25, -30}                                  | new int[]{-30, -4, -1, 2, 3, 4, 5, 25}
        new int[]{5, 5, 5, 5, 5, 5, 1, 5, 5, 5}                                 | new int[]{1, 5, 5, 5, 5, 5, 5, 5, 5, 5}
        new int[]{4, 423, 6, 6, -2, 0, 43, -423, 53432, 23, 4423}               | new int[]{-423, -2, 0, 4, 6, 6, 23, 43, 423, 4423, 53432}
        new int[]{4, 77, 5, 4, 33, 5, 7, 8, 9, 9, 9, 96, 5, 54, 33, 55, 3, 2}   | new int[]{2, 3, 4, 4, 5, 5, 5, 7, 8, 9, 9, 9, 33, 33, 54, 55, 77, 96}
        benchmarkDataGenerator.loadData(AlgorithmsBenchmarkData.FIFTY_THOUSAND) | benchmarkDataGenerator.loadData(TestBenchmarkData.SORTED_50K_BENCHMARK_DATA)
        random200                                                               | Arrays.stream(random200).sorted().toArray()
        random500                                                               | Arrays.stream(random500).sorted().toArray()
        random1200                                                              | Arrays.stream(random1200).sorted().toArray()
        random2000                                                              | Arrays.stream(random2000).sorted().toArray()
    }

    private int[] getRandomIntArray(int length) {
        var result = new int[length]
        for (int i = 0; i < length; i++) {
            result[i] = faker.number().numberBetween(-50, 50)
        }
        return result
    }
}

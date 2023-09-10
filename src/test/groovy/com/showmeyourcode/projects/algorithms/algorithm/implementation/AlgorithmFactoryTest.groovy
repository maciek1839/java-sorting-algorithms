package com.showmeyourcode.projects.algorithms.algorithm.implementation


import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType
import com.showmeyourcode.projects.algorithms.test_util.TestBase

class AlgorithmFactoryTest extends TestBase {

    def "should create a correct algorithm when a proper parameters is passed"() {
        given:
        def algorithmFactory = new AlgorithmFactory(applicationConfiguration)

        when:
        def result = algorithmFactory.createAlgorithm(type)

        then:
        result.getClass().isAssignableFrom(algorithm.getClass())

        where:
        type                               | algorithm
        AlgorithmType.BUBBLE_SORT          | new BubbleSort(algorithmDataGenerator)
        AlgorithmType.COUNTING_SORT        | new CountingSort(algorithmDataGenerator)
        AlgorithmType.HEAP_SORT            | new HeapSort(algorithmDataGenerator)
        AlgorithmType.INSERTION_SORT       | new InsertionSort(algorithmDataGenerator)
        AlgorithmType.MERGE_SORT           | new MergeSort(algorithmDataGenerator)
        AlgorithmType.QUICK_SORT           | new QuickSort(algorithmDataGenerator)
        AlgorithmType.SELECTION_SORT       | new SelectionSort(algorithmDataGenerator)
        AlgorithmType.COCKTAIL_SHAKER_SORT | new CocktailShakerSort(algorithmDataGenerator)
        AlgorithmType.SHELL_SORT           | new ShellSort(algorithmDataGenerator)
    }
}

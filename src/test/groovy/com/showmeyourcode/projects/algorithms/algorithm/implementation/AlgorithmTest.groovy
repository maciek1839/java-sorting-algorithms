package com.showmeyourcode.projects.algorithms.algorithm.implementation


import com.showmeyourcode.projects.algorithms.test_util.TestBase

class AlgorithmTest extends TestBase {

    def "should return a proper algorithm name when calling toString()"() {
        expect:
        expectedName.trim() == algorithm.toString().trim()

        where:
        expectedName      | algorithm
        "Bubble Sort "    | new BubbleSort(algorithmDataGenerator)
        "Counting Sort "  | new CountingSort(algorithmDataGenerator)
        "Insertion sort " | new InsertionSort(algorithmDataGenerator)
        "Merge sort "     | new MergeSort(algorithmDataGenerator)
    }
}

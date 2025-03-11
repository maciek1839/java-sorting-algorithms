package com.showmeyourcode.projects.exercise

import com.showmeyourcode.projects.algorithms.test_util.TestBase
import spock.lang.Unroll

import java.util.stream.IntStream

class BinarySearchExerciseTest extends TestBase {

    def "should not allow to construct an invalid instance"(){
        given:
        def arr = null

        when:
        new BinarySearchExercise<Integer>(arr)

        then:
        Exception ex = thrown(NullPointerException)
        ex.message == BinarySearchExercise.INVALID_ARGUMENT_MSG
    }

    def "should not allow to construct an object with an empty array"(){
        given:
        def arr = new Integer[0]
        def returnedIndex

        when:
        def o = new BinarySearchExercise<Integer>(arr)
        and:
        returnedIndex = o.search(1)

        then:
        noExceptionThrown()
        and:
        returnedIndex == -1
    }

    @Unroll
    def "should find a relevant index for an array with size #arr.size()"(){
        expect:
        def o = new BinarySearchExercise<Integer>(arr)
        arr.eachWithIndex { Integer entry, int i ->
            i == o.search(entry)
        }

        where:
        arr << [
                algorithmDataGenerator.mapIntArray(algorithmDataGenerator.generateIntData(1, 10000)),
                algorithmDataGenerator.mapIntArray(algorithmDataGenerator.generateIntData(10, 10000)),
                algorithmDataGenerator.mapIntArray(algorithmDataGenerator.generateIntData(100, 10000)),
                algorithmDataGenerator.mapIntArray(algorithmDataGenerator.generateIntData(1000, 10000)),
        ]
    }

    @Unroll
    def "should not find an index for an object which is not present"(){
        given:
        def arr =  algorithmDataGenerator.mapIntArray(algorithmDataGenerator.generateIntData(100, 100))
        def o = new BinarySearchExercise<Integer>(arr)

        expect:
        IntStream.range(101,150).forEach( v ->
                o.search(v) == -1
        )
        and:
        IntStream.range(-100,0).forEach( v ->
                o.search(v) == -1
        )
    }
}

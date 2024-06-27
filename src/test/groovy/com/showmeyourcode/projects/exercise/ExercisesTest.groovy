package com.showmeyourcode.projects.exercise


import com.showmeyourcode.projects.algorithms.test_util.TestBase

class ExercisesTest extends TestBase {

    def "should run the main method without errors"() {
        when:
        Exercises.main(new String[0])

        then:
        noExceptionThrown()
    }
}

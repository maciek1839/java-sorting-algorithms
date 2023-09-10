package com.showmeyourcode.projects.algorithms.configuration


import spock.lang.Specification

class SortingAppConfigurationLoaderTest extends Specification {

    def "should load application settings when the file exists"() {
        given:
        def expectedConfig = new SortingAppConfiguration(10000, 10000, 150000, "results.txt", List.of(10_000, 50_000, 100_000, 150_000))
        def classUnderTest = new SortingAppConfigurationLoader("application.properties")

        when:
        def config = classUnderTest.getConfiguration()

        then:
        expectedConfig == config
    }
}

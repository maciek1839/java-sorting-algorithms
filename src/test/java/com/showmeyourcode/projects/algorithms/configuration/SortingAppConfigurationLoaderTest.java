package com.showmeyourcode.projects.algorithms.configuration;

import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingAppConfigurationLoaderTest {

    @Test
    void should_loadAppSettings_when_fileExists() throws CannotLoadAppPropertiesException {
        var expectedConfig = new SortingAppConfiguration(10000, 10000, 150000, "results.txt", List.of(10_000,50_000,100_000,150_000));
        SortingAppConfigurationLoader classUnderTest = new SortingAppConfigurationLoader("application.properties");
        var config = classUnderTest.getConfiguration();

        assertEquals(expectedConfig, config);
    }
}

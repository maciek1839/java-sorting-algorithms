package com.showmeyourcode.projects.algorithms.configuration;

import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingAppConfigurationLoaderTest {

    @Test
    void should_loadAppSettings_when_fileExists() throws CannotLoadAppPropertiesException {
        var expectedConfig = new SortingAppConfiguration(10000, 10000, 150000);
        SortingAppConfigurationLoader classUnderTest = new SortingAppConfigurationLoader("application.properties");
        var config = classUnderTest.getConfig();

        assertEquals(expectedConfig, config);
    }
}

package com.showmeyourcode.projects.algorithms.configuration;

import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class SortingAppConfigurationLoader {

    private final SortingAppConfiguration configuration;
    private final String propsFileName;

    public SortingAppConfigurationLoader(String applicationPropertiesFileName) throws CannotLoadAppPropertiesException {
        propsFileName = applicationPropertiesFileName;
        configuration = loadDefaultConfiguration();
    }

    public SortingAppConfiguration getConfiguration() {
        return configuration;
    }

    private SortingAppConfiguration loadDefaultConfiguration() throws CannotLoadAppPropertiesException {
        log.info("Loading application configuration from file: {}", propsFileName);
        Properties loadedAppProperties;
        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);

            if (inputStream != null) {
                loadedAppProperties = new Properties();
                loadedAppProperties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propsFileName + "' not found in the classpath");
            }
        } catch (Exception e) {
            throw new CannotLoadAppPropertiesException(e);
        } finally {
            if (Objects.nonNull(inputStream)) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("Cannot close a resource stream! ", e);
                }
            }
        }

        return new SortingAppConfiguration(
                Integer.parseInt(loadedAppProperties.getProperty(PropertyKey.DATA_SIZE)),
                Integer.parseInt(loadedAppProperties.getProperty(PropertyKey.DATA_RANGE_MAX)),
                Integer.parseInt(loadedAppProperties.getProperty(PropertyKey.GENERATED_DATASET_SIZE)),
                loadedAppProperties.getProperty(PropertyKey.BENCHMARK_RESULTS_FILE),
                Arrays.stream(loadedAppProperties.getProperty(PropertyKey.BENCHMARK_DATASET_SIZES).split(",")).map(Integer::parseInt).toList()
        );
    }
}

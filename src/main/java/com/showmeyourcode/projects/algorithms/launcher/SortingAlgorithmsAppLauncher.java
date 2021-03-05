package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputInterceptor;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class SortingAlgorithmsAppLauncher {

    static final Logger logger = LoggerFactory.getLogger(SortingAlgorithmsAppLauncher.class);

    private static String PROPERTIES_FILENAME = "application.properties";
    private static InputStream DEFAULT_INPUT_STREAM = System.in;

    public static void main(String[] args) throws CannotLoadAppPropertiesException {
        logger.info("\nWelcome to The Sorting Algorithms program.");
        startApp();
    }

    static void setPropertiesFilename(String newFileName) {
        PROPERTIES_FILENAME = newFileName;
    }

    static void setDefaultInputStream(InputStream inputStream) {
        DEFAULT_INPUT_STREAM = inputStream;
    }

    static void startApp() throws CannotLoadAppPropertiesException {
        final SortingAppConfigurationLoader configLoader = new SortingAppConfigurationLoader(PROPERTIES_FILENAME);
        final UserInputInterceptor inputInterceptor = new UserInputInterceptor(configLoader.getConfig());
        inputInterceptor.startListening(DEFAULT_INPUT_STREAM);
    }
}

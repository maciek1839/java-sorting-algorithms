package com.showmeyourcode.projects.algorithms;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputInterceptor;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortingAlgorithmsAppLauncher {

    static final Logger logger = LoggerFactory.getLogger(SortingAlgorithmsAppLauncher.class);

    private static String PROPERTIES_FILENAME = "application.properties";

    public static void main(String[] args) throws CannotLoadAppPropertiesException {
        logger.debug("Welcome to The Sorting Algorithms program.");
        startApp();
    }

    static void setPropertiesFilename(String newFileName) {
        PROPERTIES_FILENAME = newFileName;
    }

    static void startApp() throws CannotLoadAppPropertiesException {
        final SortingAppConfigurationLoader configLoader = new SortingAppConfigurationLoader(PROPERTIES_FILENAME);
        final UserInputInterceptor inputInterceptor = new UserInputInterceptor(configLoader.getConfig());
        inputInterceptor.startListening();
    }
}

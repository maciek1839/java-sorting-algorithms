package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.console.UserInputInterceptor;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class SortingAlgorithmsAppLauncher {

    static final Logger logger = LoggerFactory.getLogger(SortingAlgorithmsAppLauncher.class);

    private static InputStream defaultInputStream = System.in;
    private static String propertiesFilename = "application.properties";

    public static void main(String[] args) throws CannotLoadAppPropertiesException {
        logger.info("\nWelcome to The Sorting Algorithms program.");
        startApp();
    }

    static void setDefaultInputStream(InputStream inputStream) {
        defaultInputStream = inputStream;
    }

    static void setPropertiesFilename(String newFileName) {
        propertiesFilename = newFileName;
    }

    static void startApp() throws CannotLoadAppPropertiesException {
        final SortingAppConfigurationLoader configLoader = new SortingAppConfigurationLoader(propertiesFilename);
        final UserInputInterceptor inputInterceptor = new UserInputInterceptor(configLoader.getConfig());
        inputInterceptor.startListening(defaultInputStream);
    }
}

package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import lombok.extern.slf4j.Slf4j;

import static com.showmeyourcode.projects.algorithms.launcher.SortingAlgorithmsApplication.logger;

@Slf4j
public class SortingAlgorithmsAppLauncher {

    public static void main(String[] args) throws CannotLoadAppPropertiesException {
        logger.info("\nWelcome to The Sorting Algorithms program.");
        var launcher = new SortingAlgorithmsApplication(
                SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE,
                SortingAlgorithmsApplication.DEFAULT_INPUT_STREAM
        );
        launcher.startApp();
    }
}

package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;

public class SortingAlgorithmsAppLauncher {

    public static void main(String[] args) throws CannotLoadAppPropertiesException {
        var launcher = new SortingAlgorithmsApplication(
                SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE,
                SortingAlgorithmsApplication.DEFAULT_INPUT_STREAM
        );
        launcher.startApp();
    }
}

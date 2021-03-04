package com.showmeyourcode.projects.algorithms;

import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SortingAlgorithmsAppLauncherIT {

    @Test
    void should_throwException_when_cannotLoadProperties() {
        SortingAlgorithmsAppLauncher.setPropertiesFilename("bad-file.properties");
        assertThrows(CannotLoadAppPropertiesException.class, () -> {
            SortingAlgorithmsAppLauncher.main(new String[0]);
        });
    }

    @Disabled
    @Test
    void should_exitProgram_when_PressExitOption() {
    }

}

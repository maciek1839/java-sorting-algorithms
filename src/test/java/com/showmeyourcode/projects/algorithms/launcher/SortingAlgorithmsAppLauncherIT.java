package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.console.UserMenuChoice;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SortingAlgorithmsAppLauncherIT {

    @Test
    void should_throwException_when_cannotLoadProperties() {
        SortingAlgorithmsAppLauncher.setPropertiesFilename("bad-file.properties");
        assertThrows(CannotLoadAppPropertiesException.class, () -> {
            SortingAlgorithmsAppLauncher.main(new String[0]);
        });
    }

    @Test
    void should_exitProgram_when_PressExitOption() throws CannotLoadAppPropertiesException {
        String exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice());
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(exitOption.getBytes());

        SortingAlgorithmsAppLauncher.setDefaultInputStream(testInputStream);
        SortingAlgorithmsAppLauncher.main(new String[0]);
    }

    @Disabled
    @Test
    void should_ignoreBadInput_when_nonDigitsAreWritten() {

    }

    @Disabled
    @Test
    void should_showAlgorithmUsage_when_optionAlgorithmOptionIsChosen() {

    }

    @Disabled
    @Test
    void should_doBenchmark_when_benchmarkOptionIsChosen() {

    }

}

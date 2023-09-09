package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.console.UserInputProcessor;
import com.showmeyourcode.projects.algorithms.console.UserMenuChoice;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import nl.altindag.log.LogCaptor;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortingAlgorithmsApplicationIT {

    @Test
    void should_throwException_when_cannotLoadProperties() {
        var classUnderTest = new SortingAlgorithmsApplication(
                "bad-file.properties",
                SortingAlgorithmsApplication.DEFAULT_INPUT_STREAM
        );

        assertThrows(CannotLoadAppPropertiesException.class, classUnderTest::startApp);
    }

    @Test
    void should_exitProgram_when_PressExitOption() throws CannotLoadAppPropertiesException {
        LogCaptor logCaptor = LogCaptor.forClass(UserInputProcessor.class);
        String exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice());
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(exitOption.getBytes());
        var classUnderTest = new SortingAlgorithmsApplication(
                SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE,
                testInputStream
        );

        classUnderTest.startApp();

        assertEquals(1, logCaptor.getLogs().size());
        assertEquals("Thank you and see you again!", logCaptor.getLogs().get(0));
    }


    @Test
    void should_ignoreBadInput_when_nonDigitsAreWritten() throws CannotLoadAppPropertiesException {
        LogCaptor logCaptor = LogCaptor.forClass(UserInputProcessor.class);
        String exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice());
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(
                String.format("%s\n%s\n","abc", exitOption).getBytes(StandardCharsets.UTF_8)
        );
        var classUnderTest = new SortingAlgorithmsApplication(
                SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE,
                testInputStream
        );

        classUnderTest.startApp();

        assertEquals(1, logCaptor.getLogs().size());
        assertEquals("Thank you and see you again!", logCaptor.getLogs().get(0));
    }

    @Test
    void should_showAlgorithmUsage_when_optionAlgorithmOptionIsChosen() throws CannotLoadAppPropertiesException {
        LogCaptor logCaptor = LogCaptor.forClass(UserInputProcessor.class);

        String option1 = String.valueOf(UserMenuChoice.ALGORITHM_1.getUserChoice());
        String exitOption = String.valueOf(UserMenuChoice.EXIT.getUserChoice());
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(
                String.format("%s\n%s\n",option1, exitOption).getBytes(StandardCharsets.UTF_8)
        );
        var classUnderTest = new SortingAlgorithmsApplication(
                SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE,
                testInputStream
        );

        classUnderTest.startApp();

        assertEquals(3, logCaptor.getLogs().size());
        assertEquals("Name: Bubble Sort Time: 0 s", logCaptor.getLogs().get(0));
        assertEquals("Number of elements: 10000 Max element value: 10000", logCaptor.getLogs().get(1));
        assertEquals("Thank you and see you again!", logCaptor.getLogs().get(2));
    }
}

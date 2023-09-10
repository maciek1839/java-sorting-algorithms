package com.showmeyourcode.projects.algorithms.algorithm;

import com.showmeyourcode.projects.algorithms.test_util.DefaultComponentsProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class AlgorithmDataGeneratorTest extends DefaultComponentsProvider {

    private AlgorithmDataGenerator classUnderTest;

    private int getHighestArrayValue(int[] array) {
        return Arrays.stream(array).reduce(0, (total, elem) -> Math.max(total, elem));
    }

    @BeforeEach
    void setup() {
        classUnderTest = new AlgorithmDataGenerator(applicationConfiguration);
    }

    @Test
    void should_generateIntegerData_when_sizeIsKnown() {
        int[] generatedData = classUnderTest.generateIntData();

        assertEquals(DATA_SIZE, generatedData.length);
        Assertions.assertFalse(java.util.Arrays.equals(new int[DATA_SIZE], generatedData));
        final int highestValue = getHighestArrayValue(generatedData);
        log.debug("The highest value is: {}", highestValue);
        assertTrue(highestValue <= DATA_MAX_RANGE);
    }
}

package com.showmeyourcode.projects.algorithms.algorithm;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlgorithmDataGeneratorTest {

    private AlgorithmDataGenerator classUnderTest;

    private int getHighestArrayValue(int[] array) {
        return Arrays.stream(array).reduce(0, (total, elem) -> Math.max(total, elem));
    }

    @BeforeEach
    void setup() {
        classUnderTest = new AlgorithmDataGenerator(StaticValueProvider.getConfig());
    }

    @Test
    void should_generateIntegerData_when_sizeIsKnown() {
        int[] generatedData = classUnderTest.generateIntData();

        assertEquals(StaticValueProvider.dataSize(), generatedData.length);
        Assertions.assertFalse(java.util.Arrays.equals(new int[StaticValueProvider.dataSize()], generatedData));
        final int highestValue = getHighestArrayValue(generatedData);
        System.out.println(Arrays.toString(generatedData));
        System.out.println("The highest value is: " + highestValue);
        assertTrue(highestValue <= StaticValueProvider.dataMaxRange());
    }
}

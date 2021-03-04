package com.showmeyourcode.projects.algorithms.generator;

import com.showmeyourcode.projects.algorithms.test_util.StaticValueProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataGeneratorTest {

    private DataGenerator classUnderTest;

    @BeforeEach
    void setup() {
        classUnderTest = new DataGenerator(StaticValueProvider.getConfig());
    }

    @Test
    void should_generateIntegerData_when_sizeIsKnown() {
        int[] generatedData = classUnderTest.generateIntData();

        assertEquals(StaticValueProvider.dataSize(), generatedData.length);
        Assertions.assertFalse(java.util.Arrays.equals(new int[StaticValueProvider.dataSize()], generatedData));
    }
}

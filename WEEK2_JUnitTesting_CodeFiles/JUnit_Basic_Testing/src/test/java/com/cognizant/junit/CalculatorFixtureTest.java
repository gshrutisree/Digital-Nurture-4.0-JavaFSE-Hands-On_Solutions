package com.cognizant.junit;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorFixtureTest {

    private Calculator calculator;

    // Setup method runs before every @Test
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator instance...");
        calculator = new Calculator();
    }

    // Teardown method runs after every @Test
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test...\n");
        calculator = null;
    }

    @Test
    public void testAdditionAAA() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals("Addition should be 15", 15, result);
    }

    @Test
    public void testMultiplicationAAA() {
        // Arrange
        int a = 3, b = 4;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals("Multiplication should be 12", 12, result);
    }
}

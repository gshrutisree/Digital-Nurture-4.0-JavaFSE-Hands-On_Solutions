package com.cognizant.junit;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculatorFixtureTest {

    private Calculator calculator;
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator instance...");
        calculator = new Calculator();
    }
    @After
    public void tearDown() {
        System.out.println("Cleaning up after test...\n");
        calculator = null;
    }

    @Test
    public void testAdditionAAA() {
        int a = 10, b = 5;
        int result = calculator.add(a, b);
        assertEquals("Addition should be 15", 15, result);
    }

    @Test
    public void testMultiplicationAAA() {
        int a = 3, b = 4;
        int result = calculator.multiply(a, b);
        assertEquals("Multiplication should be 12", 12, result);
    }
}

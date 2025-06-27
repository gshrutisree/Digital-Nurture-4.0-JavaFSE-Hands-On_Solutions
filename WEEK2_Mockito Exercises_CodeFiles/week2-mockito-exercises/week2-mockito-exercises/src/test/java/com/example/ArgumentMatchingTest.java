package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArgumentMatchingTest {

    interface Calculator {
        int add(int a, int b);
    }

    @Test
    public void testAddMethodWithArguments() {
        // Step 1: Create mock object
        Calculator mockCalculator = mock(Calculator.class);

        // Step 2: Call method with specific arguments
        mockCalculator.add(5, 10);

        // Step 3: Verify interaction using argument matchers
        verify(mockCalculator).add(eq(5), eq(10));
    }
}

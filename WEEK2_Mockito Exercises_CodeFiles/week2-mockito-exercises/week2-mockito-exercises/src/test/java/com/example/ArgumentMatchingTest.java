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
        Calculator mcal = mock(Calculator.class);
        mcal.add(5, 10);
        verify(mcal).add(eq(5), eq(10));
    }
}

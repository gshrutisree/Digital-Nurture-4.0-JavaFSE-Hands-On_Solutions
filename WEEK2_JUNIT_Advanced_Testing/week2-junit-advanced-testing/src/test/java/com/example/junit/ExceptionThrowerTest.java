package com.example.junit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testExceptionThrown() {
        System.out.println("Running testExceptionThrown");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });
        assertEquals("Input cannot be null", exception.getMessage());
    }

    @Test
    void testNoException() {
        System.out.println("Running testNoException");
        assertDoesNotThrow(() -> {
            thrower.throwException("valid input");
        });
    }
}

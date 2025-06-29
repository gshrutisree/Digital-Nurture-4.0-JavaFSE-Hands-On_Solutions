package com.example.junit;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest 
{
    ExceptionThrower t = new ExceptionThrower();
    @Test
    void testExceptionThrown() {
        System.out.println("Running testExceptionThrown");
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            t.throwException(null);
        });
        assertEquals("Input cannot be null", e.getMessage());
    }

    @Test
    void testNoException() 
    {
        System.out.println("Running testNoException");
        assertDoesNotThrow(() -> {
            t.throwException("valid input");
        });
    }
}

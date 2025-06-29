package com.example.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Test2 {

    @Test
    void testString() {
        assertTrue("JUnit".startsWith("J"), "String should start with 'J'");
    }
}

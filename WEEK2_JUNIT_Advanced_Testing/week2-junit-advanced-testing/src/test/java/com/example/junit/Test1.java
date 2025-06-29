package com.example.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Test1 {

    @Test
    void testAddition() {
        assertEquals(5, 2 + 3, "2 + 3 should be 5");
    }
}

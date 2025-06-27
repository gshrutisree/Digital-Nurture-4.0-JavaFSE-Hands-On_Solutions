package com.cognizant.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // assertEquals
        assertEquals("Sum should be 5", 5, 2 + 3);

        // assertTrue
        assertTrue("5 should be greater than 3", 5 > 3);

        // assertFalse
        assertFalse("3 should not be greater than 5", 3 > 5);

        // assertNull
        String nullStr = null;
        assertNull("Should be null", nullStr);

        // assertNotNull
        String notNullStr = "JUnit";
        assertNotNull("Should not be null", notNullStr);
    }
}

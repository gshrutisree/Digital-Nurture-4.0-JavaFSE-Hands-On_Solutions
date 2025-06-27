package com.cognizant.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() 
    {
        assertEquals("Sum should be 5", 5, 2 + 3);
        assertTrue("5 should be greater than 3", 5 > 3);
        assertFalse("3 should not be greater than 5", 3 > 5);
        String ns = null;
        assertNull("Should be null", ns);
        String nns = "JUnit";
        assertNotNull("Should not be null", nns);
    }
}

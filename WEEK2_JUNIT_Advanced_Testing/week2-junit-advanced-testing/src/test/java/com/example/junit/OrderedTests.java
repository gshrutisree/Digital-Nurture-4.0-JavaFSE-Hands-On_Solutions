package com.example.junit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running testC");
        assertTrue(5 > 3);
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running testA");
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running testB");
        assertNotNull("Hello");
    }
}

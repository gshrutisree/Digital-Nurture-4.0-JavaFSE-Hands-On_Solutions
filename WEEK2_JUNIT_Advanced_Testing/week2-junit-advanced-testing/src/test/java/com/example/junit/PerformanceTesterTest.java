package com.example.junit;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.Test;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testTaskCompletesWithinTimeout() {
        System.out.println("Running testTaskCompletesWithinTimeout");
        assertTimeout(Duration.ofMillis(500), () -> tester.performTask());
    }
}

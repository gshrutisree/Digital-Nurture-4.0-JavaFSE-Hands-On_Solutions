package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MultipleReturnsTest {

    interface DataProvider {
        String fetch();
    }

    @Test
    public void testMultipleReturnValues() {
        // Step 1: Create mock object
        DataProvider mockProvider = mock(DataProvider.class);

        // Step 2: Stub the method to return different values on consecutive calls
        when(mockProvider.fetch())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        // Step 3: Call the method multiple times
        System.out.println(mockProvider.fetch()); // First Call
        System.out.println(mockProvider.fetch()); // Second Call
        System.out.println(mockProvider.fetch()); // Third Call

        // Optional: You can also verify it was called 3 times
        verify(mockProvider, times(3)).fetch();
    }
}

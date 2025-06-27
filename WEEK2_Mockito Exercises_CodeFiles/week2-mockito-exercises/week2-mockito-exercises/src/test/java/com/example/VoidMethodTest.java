package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

interface Notifier {
    void send(String message);
}

public class VoidMethodTest {

    @Test
    public void testVoidMethodInteraction() {
        // Step 1: Create mock object
        Notifier mockNotifier = mock(Notifier.class);

        // Step 2: Stub the void method (optional, if needed to do nothing or throw)
        doNothing().when(mockNotifier).send(anyString());

        // Step 3: Call the method
        mockNotifier.send("Hello, Mockito!");

        // Step 4: Verify the interaction
        verify(mockNotifier).send("Hello, Mockito!");
    }
}

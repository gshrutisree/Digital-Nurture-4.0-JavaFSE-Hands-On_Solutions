package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VoidMethodExceptionTest {

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("API failure")).when(mockApi).reset();

        MyService service = new MyService(mockApi);

        // Optional: Catch the exception to verify behavior
        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.resetApi(); // Assuming MyService calls mockApi.reset()
        });

        assertEquals("API failure", exception.getMessage());
        verify(mockApi).reset();
    }
}

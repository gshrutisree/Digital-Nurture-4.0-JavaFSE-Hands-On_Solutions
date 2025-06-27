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
        ExternalApi mapi = mock(ExternalApi.class);
        doThrow(new RuntimeException("API failure")).when(mapi).reset();

        MyService s = new MyService(mapi);
        Exception e = assertThrows(RuntimeException.class, () -> {
            s.resetApi(); 
        });
        assertEquals("API failure", e.getMessage());
        verify(mapi).reset();
    }
}

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
        Notifier mn = mock(Notifier.class);
        doNothing().when(mn).send(anyString());
        mn.send("Hello, Mockito!");
        verify(mn).send("Hello, Mockito!");
    }
}

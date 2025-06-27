package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InteractionTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mapi = mock(ExternalApi.class);
        MyService s = new MyService(mapi);
        s.fetchData();
        verify(mapi).getData();
    }
}

package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InteractionTest {

    @Test
    public void testVerifyInteraction() {
        // Step 1: Create mock of ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Pass mock to service and call method
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Step 3: Verify that getData() was called once
        verify(mockApi).getData();
    }
}

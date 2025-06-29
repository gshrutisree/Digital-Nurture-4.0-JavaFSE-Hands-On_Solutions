package com.example.mockitoadv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        RestClient mrc = mock(RestClient.class);

        when(mrc.getResponse()).thenReturn("Mock Response");

        ApiService as = new ApiService(mrc);
        String ans = as.fetchData();

        assertEquals("Fetched Mock Response", ans);
    }
}

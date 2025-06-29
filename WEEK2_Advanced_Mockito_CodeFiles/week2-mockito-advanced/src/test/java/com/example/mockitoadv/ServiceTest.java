package com.example.mockitoadv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceTest {
 
    @Test
    public void testServiceWithMockRepository() {
        Repository mr = mock(Repository.class);
        when(mr.getData()).thenReturn("Mock Data");

        Service s = new Service(mr);
        String res = s.processData();

        assertEquals("Processed Mock Data", res);
    }
}

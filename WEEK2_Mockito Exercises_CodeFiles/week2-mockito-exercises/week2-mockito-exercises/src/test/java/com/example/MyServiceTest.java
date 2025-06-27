package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest 
{
    @Test
    public void testExternalApi() 
    {
        ExternalApi mapi = mock(ExternalApi.class);
        when(mapi.getData()).thenReturn("Mock Data");
        MyService s = new MyService(mapi);
        String res = s.fetchData();
        assertEquals("Mock Data", res);
    }
}

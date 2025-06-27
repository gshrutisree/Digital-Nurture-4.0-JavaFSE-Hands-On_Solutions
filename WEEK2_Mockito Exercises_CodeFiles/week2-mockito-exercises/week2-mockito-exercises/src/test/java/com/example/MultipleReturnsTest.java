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
        DataProvider mp = mock(DataProvider.class);
        when(mockProvider.fetch()).thenReturn("First Call") .thenReturn("Second Call") .thenReturn("Third Call");
        System.out.println(mp.fetch()); 
        System.out.println(mp.fetch());
        System.out.println(mp.fetch()); 
        verify(mp, times(3)).fetch();
    }
}

package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;


public class InteractionOrderTest {

    interface Service {
        void stepOne();
        void stepTwo();
        void stepThree();
    }
    @Test
    public void testMethodCallOrder() {
        Service ms = mock(Service.class);
        ms.stepOne();
        ms.stepTwo();
        ms.stepThree();
        InOrder io = inOrder(ms);
        io.verify(ms).stepOne();
        io.verify(ms).stepTwo();
        io.verify(ms).stepThree();
    }
}

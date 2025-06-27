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
        // Step 1: Create mock object
        Service mockService = mock(Service.class);

        // Step 2: Call methods in specific order
        mockService.stepOne();
        mockService.stepTwo();
        mockService.stepThree();

        // Step 3: Verify the order of interaction
        InOrder inOrder = inOrder(mockService);
        inOrder.verify(mockService).stepOne();
        inOrder.verify(mockService).stepTwo();
        inOrder.verify(mockService).stepThree();
    }
}

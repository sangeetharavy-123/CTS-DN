package com.Sangeetha.JUnitExercises;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Mocking_Stubbing{

    @Test
    public void testExternalApi() {

        // Step 1: Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        
        // Step 2: Stub method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into service
        MyService service = new MyService(mockApi);

        // Step 4: Call method
        String result = service.fetchData();

        // Step 5: Assert
        assertEquals("Mock Data", result);
    }
}

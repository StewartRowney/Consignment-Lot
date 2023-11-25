package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.services.ITruckService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class TruckControllerNoSpringTest {
    private final ITruckService mockService = mock(ITruckService.class);
    private final TruckController uut = new TruckController(mockService);

    @Test
    void test_GetAllTrucks_ValidRequest() {
        uut.getAllTrucks();
        verify(mockService, times(1)).getAllTrucks();
    }
}

package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.services.IVehicleService;
import com.example.ConsignmentLot.services.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class VehicleControllerNoSpringTest {

    private final IVehicleService mockService = mock(VehicleService.class);
    private final VehicleController uut = new VehicleController(mockService);

    @Test
    void getAllVehicles() {
        uut.getAllVehicles();
        verify(mockService, times(1)).getAllVehicles();
    }
}
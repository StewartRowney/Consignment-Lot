package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.services.ICarService;
import com.example.ConsignmentLot.services.IVehicleService;
import com.example.ConsignmentLot.services.VehicleService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class CarControllerNoSpringTest {
    private final ICarService mockService = mock(ICarService.class);
    private final CarController uut = new CarController(mockService);

    @Test
    void test_GetAllCars_ValidRequest() {
        uut.getAllCars();
        verify(mockService, times(1)).getAllCars();
    }
}
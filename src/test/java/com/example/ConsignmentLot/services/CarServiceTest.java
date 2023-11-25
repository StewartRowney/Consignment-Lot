package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IVehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
class CarServiceTest {

    @MockBean
    private IVehicleRepository mockRepository;

    @Autowired
    private CarService uut;

    @Test
    void test_GetAllCars_ValidRequest() {
        uut.getAllCars();
        verify(mockRepository, times(1)).findAllCars();
    }
}

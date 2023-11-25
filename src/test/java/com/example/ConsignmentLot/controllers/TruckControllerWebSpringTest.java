package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.services.ITruckService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(TruckController.class)
@ActiveProfiles("test")
public class TruckControllerWebSpringTest {

    @MockBean
    private ITruckService mockService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_GetAllTrucks_ValidRequest() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/trucks");
        mockMvc.perform(requestBuilder);
        verify(mockService, times(1)).getAllTrucks();
    }

}

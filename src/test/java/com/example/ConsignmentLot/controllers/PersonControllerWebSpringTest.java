package com.example.ConsignmentLot.controllers;

import com.example.ConsignmentLot.entities.Person;
import com.example.ConsignmentLot.services.IPersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebMvcTest(PersonController.class)
@ActiveProfiles("test")
class PersonControllerWebSpringTest {

    @MockBean
    IPersonService mockService;

    @Autowired
    MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());


    @Test
    void addPerson() throws Exception {
        Person person = new Person("Jim", LocalDateTime.of(2000,10,10,14,55));
        String json = mapper.writeValueAsString(person);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(mockService, times(1)).addPerson(any(Person.class));
    }
}
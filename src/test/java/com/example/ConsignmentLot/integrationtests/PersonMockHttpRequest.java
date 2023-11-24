package com.example.ConsignmentLot.integrationtests;

import com.example.ConsignmentLot.entities.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@ActiveProfiles("test")
public class PersonMockHttpRequest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper;

    @BeforeEach
    void beforeEach(){
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Test
    void testAddPerson() throws Exception {

        int numberOfPersonsBeforeAdd = getAllPersons().length;

        Person person = new Person("Jim", LocalDateTime.of(2000,10,10,14,55));
        Person actualperson = addPerson(person);
        int numberOfPersonsAfterAdd = getAllPersons().length;

        assertAll(
                () -> assertEquals(person.getName(), actualperson.getName()),
                () -> assertEquals(person.getDateOfBirth(), actualperson.getDateOfBirth()),
                () -> assertEquals(numberOfPersonsBeforeAdd + 1, numberOfPersonsAfterAdd)
        );

    }

    private Person addPerson(Person person) throws Exception {
        String json = mapper.writeValueAsString(person);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = (mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn());

        String contentAsJson = result.getResponse().getContentAsString();
        return mapper.readValue(contentAsJson, Person.class);
    }

    private Person[] getAllPersons() throws Exception {
        MvcResult result =
                (this.mockMvc.perform(MockMvcRequestBuilders.get("/persons")))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        String contentAsJson = result.getResponse().getContentAsString();
        return mapper.readValue(contentAsJson, Person[].class);
    }
}

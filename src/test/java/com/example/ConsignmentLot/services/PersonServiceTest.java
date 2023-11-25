package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.IPersonRepository;
import com.example.ConsignmentLot.entities.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PersonServiceTest {

    @MockBean
    private IPersonRepository mockRepository;

    @Autowired
    private PersonService uut;

    @Test
    void test_GetAllPerson_ValidRequest() {
        uut.getAllPersons();
        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void test_AddPerson_ValidRequest() {
        Person person = new Person("Jim", LocalDateTime.of(2000, Month.MAY, 13, 15, 43));
        uut.addPerson(person);
        verify(mockRepository, times(1)).save(person);
    }

    @Test
    void test_AddPerson_InvalidRequest_HasId() {
        Person person = getPerson();
        assertThrows(ResponseStatusException.class, () -> uut.addPerson(person));
    }

    private Person getPerson() {
        try {
            String json = """
                    {
                      "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
                      "name": "string",
                      "dateOfBirth": "2023-11-25 13:12:19"
                    }""";

            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return mapper.readValue(json, Person.class);
        }
        catch (JsonProcessingException ex) {
            return new Person();
        }

    }
}

package com.example.ConsignmentLot.services;

import com.example.ConsignmentLot.data.PersonRepository;
import com.example.ConsignmentLot.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDateTime;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceTest {

    @MockBean
    PersonRepository mockRepo;

    @Autowired
    PersonService uut;

        @Test
        void test_AddPerson_ValidRequest() {
            Person person = new Person("Jim", LocalDateTime.MIN);
            uut.addPerson(person);
            verify(mockRepo, times(1)).save(person);
        }
    }

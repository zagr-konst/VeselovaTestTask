package com.zagr.konst.VeselovaTestTask.controllerTests;


import com.zagr.konst.VeselovaTestTask.model.Person;
import com.zagr.konst.VeselovaTestTask.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PersonControllerTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    PersonService personService;


    @Test
    public void getUserByIdTest() throws Exception {
        Person personId_1 = personService.readById(1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("years_old").value(
                                LocalDate.now().getYear() - personId_1.getBirthDate().getYear()));
    }

    @Test
    public void getNotExistingUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/999")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound());
    }

}

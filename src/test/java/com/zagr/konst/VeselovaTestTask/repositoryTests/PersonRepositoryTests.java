package com.zagr.konst.VeselovaTestTask.repositoryTests;

import com.zagr.konst.VeselovaTestTask.model.Person;
import com.zagr.konst.VeselovaTestTask.service.PersonService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
public class PersonRepositoryTests {

    @Autowired
    PersonService personService;

    @Test
    @BeforeTestClass
    void createPersonTest(){
        Person person = new Person("Elon","Musk",
                LocalDate.of(1971, Month.JUNE,28));
        personService.create(person);

        Person actual = personService.readById(person.getId());
        Assertions.assertEquals("Elon",actual.getFirst_name());
    }

    @Test
    void readPersonTest(){
        Person person = personService.readById(2);
        Assertions.assertEquals("Gates",person.getLast_name());
    }


    @Test
    void updatePersonTest(){
        Person person = personService.readById(10);

        person.setLast_name("Twitter-Musk");
        personService.update(person);

        Person actual = personService.readById(person.getId());
        Assertions.assertEquals("Twitter-Musk",actual.getLast_name());
    }

}

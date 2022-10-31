package com.zagr.konst.VeselovaTestTask.controller;

import com.zagr.konst.VeselovaTestTask.dto.PersonResponse;
import com.zagr.konst.VeselovaTestTask.model.Person;
import com.zagr.konst.VeselovaTestTask.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private PersonService personService;

    Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable long id){

/*        Person ps = new Person("Konstantin","Zagrevskiy",
                LocalDate.of(2003, Month.SEPTEMBER,25));

        personService.create(ps);*/

        Person person = personService.readById(id);
        logger.info("got info about a person with id: "+id);

        return new PersonResponse(person);

    }


}

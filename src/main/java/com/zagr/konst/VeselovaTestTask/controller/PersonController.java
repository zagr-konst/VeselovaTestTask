package com.zagr.konst.VeselovaTestTask.controller;

import com.zagr.konst.VeselovaTestTask.dto.PersonResponse;
import com.zagr.konst.VeselovaTestTask.model.Person;
import com.zagr.konst.VeselovaTestTask.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/person")
public class PersonController {
    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonResponse getPerson(@PathVariable long id){

        Person person = personService.readById(id);
        log.info("got info about a person with id: "+id);

        return new PersonResponse(person);

    }


}

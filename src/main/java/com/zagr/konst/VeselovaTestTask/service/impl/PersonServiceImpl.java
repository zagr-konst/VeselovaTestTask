package com.zagr.konst.VeselovaTestTask.service.impl;

import com.zagr.konst.VeselovaTestTask.model.Person;
import com.zagr.konst.VeselovaTestTask.repository.PersonRepository;
import com.zagr.konst.VeselovaTestTask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person create(Person person) {
        return null;
    }

    @Override
    public Person readById(long id) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }
}
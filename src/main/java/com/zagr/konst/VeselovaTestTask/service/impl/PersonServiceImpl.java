package com.zagr.konst.VeselovaTestTask.service.impl;

import com.zagr.konst.VeselovaTestTask.model.Person;
import com.zagr.konst.VeselovaTestTask.repository.PersonRepository;
import com.zagr.konst.VeselovaTestTask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
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
        if (person != null){
            return personRepository.save(person);
        }

        throw new NullPointerException();
    }

    @Override
    public Person readById(long id) {
        return personRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("User with id " + id + " not found")
        );
    }

    @Override
    public Person update(Person person) {
        if (person != null) {
            readById(person.getId());
            return personRepository.save(person);
        }
        throw new NullPointerException("User cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        Person person = readById(id);
        personRepository.delete(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}

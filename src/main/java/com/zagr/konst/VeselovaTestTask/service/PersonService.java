package com.zagr.konst.VeselovaTestTask.service;

import com.zagr.konst.VeselovaTestTask.model.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    Person readById(long id);

    Person update(Person person);

    void delete(long id);

    List<Person> getAll();

}

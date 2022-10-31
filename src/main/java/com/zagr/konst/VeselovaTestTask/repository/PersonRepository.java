package com.zagr.konst.VeselovaTestTask.repository;

import com.zagr.konst.VeselovaTestTask.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}

package com.zagr.konst.VeselovaTestTask.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.zagr.konst.VeselovaTestTask.model.Person;
import lombok.Value;

import java.time.LocalDate;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonResponse {

    private String first_name;

    private String last_name;

    private Integer years_old;

    public PersonResponse(Person person) {
        this.first_name=person.getFirst_name();
        this.last_name=person.getLast_name();
        this.years_old = LocalDate.now().getYear() - person.getBirthDate().getYear();
    }
}

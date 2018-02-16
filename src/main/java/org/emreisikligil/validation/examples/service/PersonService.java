package org.emreisikligil.validation.examples.service;

import org.emreisikligil.validation.examples.model.Person;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PersonService {

    @NotEmpty
    private String name;

    public PersonService() { }

    @Valid
    public PersonService(@NotEmpty String name) {
        this.name = name;
    }

    @NotNull
    @Valid
    public Person createPerson(@NotEmpty String name, @NotEmpty String lastname) {
        Person person = new Person();
        person.setId("1234-5678");
        person.setName(name);
        person.setLastname(lastname);

        return person;
    }
}

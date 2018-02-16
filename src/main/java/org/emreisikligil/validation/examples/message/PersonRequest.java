package org.emreisikligil.validation.examples.message;

import org.emreisikligil.validation.examples.model.Person;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PersonRequest {

    @Valid
    @NotNull
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }
}

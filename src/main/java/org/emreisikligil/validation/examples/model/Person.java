package org.emreisikligil.validation.examples.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Person {

    @NotEmpty(message = "Person name cannot be empty")
    String name;

    @NotEmpty
    String lastname;

    @Pattern(regexp = "\\w{4}-\\w{4}")
    String id;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}

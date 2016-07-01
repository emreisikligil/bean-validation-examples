/*
 * MONITISE CONFIDENTIAL
 * ____________________
 * Copyright 2003 - 2015 Monitise Group Limited
 * All Rights Reserved. www.monitisegroup.com
 * NOTICE: All information contained herein is, and remains
 * the property of Monitise Group Limited or its group
 * companies. The intellectual and technical concepts contained
 * herein are proprietary to Monitise Group Limited and Monitise
 * group companies and may be covered by U.S. and
 * Foreign Patents, patents in process, and are protected by
 * trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior
 * written permission is obtained from Monitise Group Limited. Any
 * reproduction of this material must contain this notice
 */

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
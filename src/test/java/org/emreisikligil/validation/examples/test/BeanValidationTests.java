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

package org.emreisikligil.validation.examples.test;

import org.emreisikligil.validation.examples.message.PersonRequest;
import org.emreisikligil.validation.examples.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTests {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private Validator validator;

    @Before
    public void setup() {
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testValidate() {
        Person person = new Person();
        person.setName("Emre");
        person.setLastname("Isikligil");
        person.setId("1234-5678");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void testObjectGraphValidation() {
        Person person = new Person();
        person.setName("Emre");
        person.setLastname("Isikligil");
        person.setId("1234-5678");

        PersonRequest personRequest = new PersonRequest();
        personRequest.setPerson(person);

        Set<ConstraintViolation<PersonRequest>> violations = validator.validate(personRequest);

        Assert.assertEquals(0, violations.size());
    }
}

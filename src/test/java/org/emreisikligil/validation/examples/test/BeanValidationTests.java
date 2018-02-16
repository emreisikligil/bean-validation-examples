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

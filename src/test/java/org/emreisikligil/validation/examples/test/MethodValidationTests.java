package org.emreisikligil.validation.examples.test;

import org.emreisikligil.validation.examples.service.DivideService;
import org.emreisikligil.validation.examples.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.util.Set;

public class MethodValidationTests {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    private ExecutableValidator validator;

    @Before
    public void setup() {
        validator = validatorFactory.getValidator().forExecutables();
    }

    @Test
    public void testMethodParameter() throws Exception {
        PersonService personService = new PersonService();

        Set<ConstraintViolation<PersonService>> violations = validator.validateParameters(personService,
                PersonService.class.getMethod("createPerson", String.class, String.class),
                new Object[]{"Emre", "Isikligil"});

        Assert.assertTrue(violations.isEmpty());
    }

    @Test
    public void testMethodReturnValue() throws Exception {
        PersonService personService = new PersonService();

        Set<ConstraintViolation<PersonService>> violations = validator.validateReturnValue(personService,
                PersonService.class.getMethod("createPerson", String.class, String.class),
                personService.createPerson("Emre", "Isikligil"));

        Assert.assertTrue(violations.isEmpty());
    }

    @Test
    public void tesConstructorReturnValue() throws Exception {
        Set<ConstraintViolation<PersonService>> violations = validator.validateConstructorReturnValue(
                PersonService.class.getConstructor(String.class), new PersonService("Emre"));

        Assert.assertTrue(violations.isEmpty());
    }

    @Test
    public void testDivideService() throws Exception {
        DivideService divideService = new DivideService();

        Set<ConstraintViolation<DivideService>> violations = validator.validateParameters(divideService,
                DivideService.class.getMethod("divide", long.class, long.class),
                new Long[] {50L, 50L});

        Assert.assertTrue(violations.isEmpty());
    }
}

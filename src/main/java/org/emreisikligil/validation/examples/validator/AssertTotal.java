package org.emreisikligil.validation.examples.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AssertTotalValidator.class)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AssertTotal {

    String message() default "Sum of parameters is not equal to defined total.";

    Class[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    long value() default 100L;
}

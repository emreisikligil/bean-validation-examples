package org.emreisikligil.validation.examples.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class AssertTotalValidator implements ConstraintValidator<AssertTotal, Object[]> {

    private long totalConstraint;

    @Override
    public void initialize(final AssertTotal constraintAnnotation) {
        totalConstraint = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(final Object[] value, final ConstraintValidatorContext context) {
        if (2 != value.length) {
            return false;
        }

        long total = (Long) value[0] + (Long) value[1];

        return total == totalConstraint;
    }
}

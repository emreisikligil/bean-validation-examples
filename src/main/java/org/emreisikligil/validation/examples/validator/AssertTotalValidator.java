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

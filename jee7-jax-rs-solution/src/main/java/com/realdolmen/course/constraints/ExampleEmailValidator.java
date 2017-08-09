package com.realdolmen.course.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by cda5732 on 3/03/2017.
 */
public class ExampleEmailValidator implements ConstraintValidator<ExampleEmail, String> {

    @Override
    public void initialize(ExampleEmail uniquePersonEmail) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null
                && !value.trim().equals("")
                && value.endsWith("@example.com")
                && !value.startsWith("@example.com");

    }
}

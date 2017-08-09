package com.realdolmen.course.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by cda5732 on 3/03/2017.
 */
@Constraint(validatedBy = {ExampleEmailValidator.class}) // filled in!
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface ExampleEmail {
    String message() default "{com.realdolmen.course.constraints.ExampleEmail}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

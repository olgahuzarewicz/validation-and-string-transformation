package com.example.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = NonStringConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonStringConstraint {
    String message() default "The input list can contain only items made of letters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.regex.Pattern;

public class NonStringConstraintValidator implements ConstraintValidator<NonStringConstraint, List<String>> {

    @Override
    public boolean isValid(List<String> values, ConstraintValidatorContext context) {
        return values.stream().allMatch(s -> Pattern.matches("[a-zA-Z_]+", s));
    }
}
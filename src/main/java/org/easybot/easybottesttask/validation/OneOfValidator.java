package org.easybot.easybottesttask.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
public class OneOfValidator implements ConstraintValidator<OneOf, Integer> {

    int[] arrayOfValues;

    @Override
    public void initialize(OneOf constraintAnnotation) {
        this.arrayOfValues = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return  Arrays.stream(arrayOfValues).anyMatch(v -> v == value);
    }
}

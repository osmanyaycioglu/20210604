package com.training.spring.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithCheck implements ConstraintValidator<StartWith, String> {

    private StartWith anno;

    @Override
    public void initialize(final StartWith annoParam) {
        this.anno = annoParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.anno.value());
    }

}

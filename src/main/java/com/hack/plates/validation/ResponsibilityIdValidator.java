package com.hack.plates.validation;

import com.hack.plates.repository.ResponsibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ResponsibilityIdValidator implements ConstraintValidator<ResponsibilityId, Long> {

    private final ResponsibilityRepository responsibilityRepository;

    @Autowired
    public ResponsibilityIdValidator(ResponsibilityRepository responsibilityRepository) {
        this.responsibilityRepository = responsibilityRepository;
    }

    @Override
    public void initialize(ResponsibilityId constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return responsibilityRepository.findById(id).isPresent();
    }

}

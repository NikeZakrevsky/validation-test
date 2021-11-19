package com.example.validatorschain.validators;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class ValidationManager {

    private final List<Validator> validatorList;

    public ValidationManager(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

    public <T> List<T> getValidators(Class<T> clazz) {
        return validatorList.stream()
                .filter(validator -> clazz.isAssignableFrom(validator.getClass()))
                .sorted(
                        Comparator.comparingInt(validator ->
                                validator.getClass().getAnnotation(CustomValidator.class).priority()))
                .map(validator -> ((T) validator))
                .toList();
    }
}

package com.example.validatorschain.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidationManager {

    private final List<Validator> validatorList;

    public ValidationManager(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

    public List<Validator> getValidators(Class<?> clazz) {
        return validatorList.stream()
                .filter(validator -> clazz.isAssignableFrom(validator.getClass()))
                .toList();
    }
}

package com.example.validatorschain.validators;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@CustomValidator(priority = 1)
public class LengthValidator implements TextValidator {

    private final int MAX_LENGTH = 5;

    @Override
    public List<String> validate(String data) {
       if (data == null || data.length() > MAX_LENGTH) {
           return List.of("The string is too long");
       }

       return Collections.emptyList();
    }
}

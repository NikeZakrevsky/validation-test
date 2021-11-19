package com.example.validatorschain.validators;

import java.util.Collections;
import java.util.List;

@CustomValidator(priority = 2)
public class EmptyValidator implements TextValidator {
    @Override
    public List<String> validate(String data) {
        if (data == null || data.isEmpty()) {
            return List.of("Empty or null string");
        }

        return Collections.emptyList();
    }
}

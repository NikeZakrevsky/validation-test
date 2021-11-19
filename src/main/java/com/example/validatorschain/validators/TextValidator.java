package com.example.validatorschain.validators;

import java.util.List;

public interface TextValidator extends Validator {
    List<String> validate(String data);
}

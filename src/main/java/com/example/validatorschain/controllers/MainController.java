package com.example.validatorschain.controllers;

import com.example.validatorschain.validators.TextValidator;
import com.example.validatorschain.validators.ValidationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final ValidationManager validationManager;

    public MainController(ValidationManager validationManager) {
        this.validationManager = validationManager;
    }

    @RequestMapping(value = "/")
    public List<String> home(@RequestParam(value = "data", required = false) String value) {
        return validationManager.getValidators(TextValidator.class).stream()
                .flatMap(validator -> validator.validate(value).stream())
                .toList();
    }

}

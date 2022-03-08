package com.example.receipt.service.impl;

import com.example.receipt.service.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class EmailValidatorImpl implements EmailValidator {
    @Override
    public boolean test (String s) {

        // TODO: Regex to validate email
        return true;
    }
}

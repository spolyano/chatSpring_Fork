package com.example.chat.services;

import com.example.chat.models.Errors;
import org.springframework.stereotype.Service;

@Service
public class ErrorsService {
    public Errors empty(String emptyFields) {
        return new Errors(400, emptyFields, emptyFields);
    }
}

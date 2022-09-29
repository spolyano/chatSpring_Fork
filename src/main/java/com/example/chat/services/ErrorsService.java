package com.example.chat.services;

import com.example.chat.models.Errors;
import org.springframework.stereotype.Service;

@Service
public class ErrorsService {
    public Errors empty(String error) {
        return new Errors(400, error, error);
    }

    public Errors serverError(String error) {
        return new Errors(500, error, error);
    }
}

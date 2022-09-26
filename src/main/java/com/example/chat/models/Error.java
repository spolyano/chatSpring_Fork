package com.example.chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private Integer status;
    private String title;
    private String details;
}

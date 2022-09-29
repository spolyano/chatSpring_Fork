package com.example.chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Errors {
    @NotNull
    private Integer status;
    @NotBlank
    private String title;
    @NotBlank
    private String details;
}

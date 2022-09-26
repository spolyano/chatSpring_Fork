package com.example.chat.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Message {
    private UUID id;
    @NotBlank
    private String userName;
    @NotBlank
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z", timezone = "GMT")
    private OffsetDateTime date;
    private String type;
}

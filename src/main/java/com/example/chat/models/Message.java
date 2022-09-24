package com.example.chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Message {
    private UUID id;
    private String userName;
    private String message;
    private LocalDateTime date;
}

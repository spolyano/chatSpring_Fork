package com.example.chat.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {
//    private long id;
    private String userName;
    private String message;
    private LocalDateTime date;
}

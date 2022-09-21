package com.example.chat.services;

import com.example.chat.models.Message;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<Message> chat = new ArrayList<>();
//    private long ID = 0;

    {
        chat.add(new Message("user", "test message", LocalDateTime.now()));
        chat.add(new Message("userNew", "test message kek", LocalDateTime.now()));
    }

    public List<Message> listMessages() {
        return chat;
    }

    public void saveMessage(Message messages) {
//        messages.setId(++ID);
        messages.setDate(LocalDateTime.now());
        this.chat.add(messages);
    }
}

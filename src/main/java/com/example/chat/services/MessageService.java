package com.example.chat.services;

import com.example.chat.models.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    private List<Message> chat = new ArrayList<>();

    {
        chat.add(new Message(UUID.randomUUID(), "user", "test message", LocalDateTime.now()));
        chat.add(new Message(UUID.randomUUID(), "userNew", "test message kek", LocalDateTime.now()));
    }

    public List<Message> listMessages() {
        return chat;
    }

    public void saveMessage(Message messages) {
        messages.setId(UUID.randomUUID());
        messages.setDate(LocalDateTime.now());
        this.chat.add(messages);
    }
}

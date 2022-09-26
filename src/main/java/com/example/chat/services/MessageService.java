package com.example.chat.services;

import com.example.chat.enums.TypeEnum;
import com.example.chat.models.Message;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    private final List<Message> chat = new ArrayList<>();

    {
        chat.add(new Message(UUID.randomUUID(), "user", "test message", OffsetDateTime.now(), TypeEnum.MESSAGE.type));
        chat.add(new Message(UUID.randomUUID(), "userNew", "test message kek", OffsetDateTime.now(), TypeEnum.MESSAGE.type));
    }

    public List<Message> listMessages() {
        return chat;
    }

    public Message save(String userName, String message) {
        Message messages = new Message(UUID.randomUUID(), userName, message, OffsetDateTime.now(), TypeEnum.MESSAGE.type);
        this.chat.add(messages);
        return messages;
    }
}

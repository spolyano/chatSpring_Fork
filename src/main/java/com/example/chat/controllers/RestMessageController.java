package com.example.chat.controllers;

import com.example.chat.models.Message;
import com.example.chat.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestMessageController {
    private final MessageService messageService;

    @GetMapping("/api/v1")
    public String chatJSON(Model model) {
        return messageService.listMessages().toString();
    }

    @PostMapping("/api/v1/new")
    public String createMessage(Message message) {
        messageService.saveMessage(message);
        return "saved";
    }
}

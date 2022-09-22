package com.example.chat.controllers;

import com.example.chat.models.Message;
import com.example.chat.services.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestMessageController {
    private final MessageService messageService;

    @GetMapping("/api/v1/messages")
    public ResponseEntity<String> chatJSON(Model model) throws JsonProcessingException {
        final ObjectMapper mapper = JsonMapper.builder().addModules(new JavaTimeModule()).build();
        String json = mapper.writeValueAsString(messageService.listMessages());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/messages")
    public String createMessage(Message message) {
        messageService.saveMessage(message);
        return "saved";
    }
}

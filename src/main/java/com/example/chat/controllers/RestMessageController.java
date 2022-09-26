package com.example.chat.controllers;

import com.example.chat.services.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/v1/messages")
public class RestMessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<String> getChat(Model model) throws JsonProcessingException {
        String json = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(messageService.listMessages());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> postChat(@RequestParam @NotBlank String userName, @RequestParam @NotBlank String message) {
        messageService.save(userName, message);
        return ResponseEntity.ok("valid");
    }
}

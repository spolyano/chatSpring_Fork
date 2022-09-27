package com.example.chat.controllers;

import com.example.chat.services.ErrorsService;
import com.example.chat.services.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/api/v1/messages")
public class RestMessageController {
    private final MessageService messageService;
    private final ErrorsService errorsService;

    @GetMapping
    public ResponseEntity<String> getChat(Model model) throws JsonProcessingException {
        String resp = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(messageService.listMessages());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(resp, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> postChat(@RequestParam @NotBlank String userName, @RequestParam @NotBlank String message) throws JsonProcessingException {
        String resp = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(messageService.save(userName, message));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(resp, responseHeaders, HttpStatus.CREATED);
    }

    @ResponseBody
    @ExceptionHandler({MissingServletRequestParameterException.class, HttpMessageNotReadableException.class, TypeMismatchException.class})
    public ResponseEntity<String> emptyField(Exception exception) throws JsonProcessingException {
        String resp = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(errorsService.empty(exception.getMessage()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(resp, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResponseEntity<String> serverProblem(Exception exception) throws JsonProcessingException {
        String resp = JsonMapper.builder().addModules(new JavaTimeModule()).build().writeValueAsString(errorsService.serverError(exception.getMessage()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(resp, responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

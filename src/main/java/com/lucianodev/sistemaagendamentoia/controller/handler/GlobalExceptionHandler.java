package com.lucianodev.sistemaagendamentoia.controller.handler;

import com.lucianodev.sistemaagendamentoia.dto.CustomErrorDto;
import com.lucianodev.sistemaagendamentoia.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomErrorDto> dataIntegrityViolation(HttpServletRequest request) {
        String msgLimpa = "Conflito de dados: Já existe um registro com essas informações (ex: nome duplicado).";
        return builderResponse(HttpStatus.CONFLICT, msgLimpa, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDto> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request) {
        return builderResponse(HttpStatus.NOT_FOUND, e.getMessage(), request);
    }

    public ResponseEntity<CustomErrorDto> builderResponse(HttpStatus status, String msg, HttpServletRequest request) {
        CustomErrorDto error = new CustomErrorDto(Instant.now(), status.value(), msg, request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}

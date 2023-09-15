package com.serviciosAdministrativos.servicios.util.votaciones.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationErrorHandler {
    @ExceptionHandler(RuntimeException.class)
    public static ResponseEntity<Map<String, String>> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public static ResponseEntity<Map<String, String>> handleValidation(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", e.getMessage()));
    }

    public static ResponseEntity<Map<String, String>> validationError(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", bindingResult.getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}

    
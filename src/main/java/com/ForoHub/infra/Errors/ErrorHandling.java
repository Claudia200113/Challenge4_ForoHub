package com.ForoHub.infra.Errors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.access.AccessDeniedException;

@RestControllerAdvice
@ControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> HandleError403(AccessDeniedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: " + e.getMessage());
    }

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity HandleError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity HandleError400(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(ValidationErrorDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationError(ValidationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record ValidationErrorDTO(String field, String error){
        public ValidationErrorDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

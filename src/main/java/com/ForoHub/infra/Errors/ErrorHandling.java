package com.ForoHub.infra.Errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler (EntityNotFoundException.class)
    public ResponseEntity HandleError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity HandleError400(MethodArgumentNotValidException e){
        var errors = e.getFieldErrors().stream().map(ValidationErrorDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    private record ValidationErrorDTO(String field, String error){
        public ValidationErrorDTO(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}

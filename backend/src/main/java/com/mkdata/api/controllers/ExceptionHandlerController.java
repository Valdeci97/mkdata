package com.mkdata.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mkdata.api.exceptions.ClientAlreadyExistsException;
import com.mkdata.api.exceptions.GlobalError;

@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler(ClientAlreadyExistsException.class)
  public ResponseEntity<GlobalError> handleConflitcException(RuntimeException err) {
    GlobalError message = new GlobalError(err.getMessage());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
  }

  @ExceptionHandler
  public ResponseEntity<GlobalError> handleNotFoundException(RuntimeException err) {
    GlobalError message = new GlobalError(err.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }
}

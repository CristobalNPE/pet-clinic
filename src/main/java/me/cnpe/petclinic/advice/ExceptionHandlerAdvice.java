package me.cnpe.petclinic.advice;

import me.cnpe.petclinic.exception.DuplicatedResourceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @ExceptionHandler(DuplicatedResourceException.class)
  public ResponseEntity<ErrorDetails> handleException(Exception e) {
    var errorDetails = new ErrorDetails(e.getMessage());

    return ResponseEntity.badRequest().body(errorDetails);

  }

  record ErrorDetails(String errorMessage) {
  }
}

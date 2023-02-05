package me.cnpe.petclinic.advice;

import me.cnpe.petclinic.exception.DuplicatedResourceException;
import me.cnpe.petclinic.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @ExceptionHandler(DuplicatedResourceException.class)
  public ResponseEntity<ErrorDetails> handleDuplicatedResourceException(Exception e) {
    var errorDetails = new ErrorDetails(e.getMessage());
    return ResponseEntity.badRequest().body(errorDetails);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(Exception e) {
    return ResponseEntity.notFound().build();
  }

  record ErrorDetails(String errorMessage) {
  }
}

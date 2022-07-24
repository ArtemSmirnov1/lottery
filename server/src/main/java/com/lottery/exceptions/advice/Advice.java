package com.lottery.exceptions.advice;

import com.lottery.exceptions.NotEnoughParticipantsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {

  @ExceptionHandler(NotEnoughParticipantsException.class)
  public ResponseEntity<String> handleException(NotEnoughParticipantsException e) {
    return returnMessage(e);
  }

  private ResponseEntity<String> returnMessage(Exception e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }
}

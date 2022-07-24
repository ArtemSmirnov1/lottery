package com.lottery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughParticipantsException extends RuntimeException{
  public NotEnoughParticipantsException(String text) {
    super("Error! The system should contain at least 2 participants! " + text);
  }
}

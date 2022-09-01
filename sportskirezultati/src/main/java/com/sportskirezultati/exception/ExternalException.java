package com.sportskirezultati.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExternalException extends RuntimeException {

  public ExternalException(String message) {
    super(message);
  }
}

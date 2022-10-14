package com.mkdata.api.exceptions;

public class CorporateClientAlreadyExistsException extends RuntimeException {
  public CorporateClientAlreadyExistsException(String message) {
    super(message);
  }
}

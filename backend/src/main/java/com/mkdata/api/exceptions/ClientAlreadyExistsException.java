package com.mkdata.api.exceptions;

public class ClientAlreadyExistsException extends RuntimeException {
  public ClientAlreadyExistsException(String message) {
    super(message);
  }
}

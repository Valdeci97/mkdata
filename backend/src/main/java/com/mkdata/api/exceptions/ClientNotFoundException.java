package com.mkdata.api.exceptions;

public class ClientNotFoundException extends RuntimeException {
  public ClientNotFoundException(String message) {
    super(message);
  }
}

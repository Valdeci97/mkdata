package com.mkdata.api.exceptions;

public class GlobalError {
  private String err;

  public GlobalError(String err) {
    this.err = err;
  }

  public String getErr() {
    return this.err;
  }

  public void setErr(String err) {
    this.err = err;
  }
}

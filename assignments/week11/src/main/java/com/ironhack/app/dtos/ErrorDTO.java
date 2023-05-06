package com.ironhack.app.dtos;

public class ErrorDTO<T> implements ResponseDTO{

  protected int statusCode;
  protected String message;

  public ErrorDTO(int statusCode, String message ){
    setStatusCode(statusCode);
    setMessage(message);
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
